import java.util.*;

class Solution {
    public int[] solution(String msg) {
        String[] initialWords = {"", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        
        // msg 길이
        int n = msg.length();
        // 단어 index 추적
        int s = 0;
        
        // 단어 사전
        List<String> dic = new ArrayList<>(Arrays.asList(initialWords));
        // index 저장 리스트
        List<Integer> list = new ArrayList<>();
        
        // s(탐색 index)가 n보다 작을 때 반복
        while (s < n) {
            StringBuilder currentWord = new StringBuilder();
            // 단어 1글자를 가져오기(무조건 사전에 존재하고 있음)
            currentWord.append(msg.charAt(s));
            
            // s+1이 n보다 작고 사전에 없을 때까지 반복하기
            while (s+1 < n && dic.contains(currentWord.toString() + msg.charAt(s+1))) {
                s++;
                currentWord.append(msg.charAt(s));
            }
            
            // 현재 단어는 더 이상 단어를 추가할 수 없거나 사전에 없는 단어
            
            // index 추가하기
            list.add(dic.indexOf(currentWord.toString()));
            
            // s+1이 n보다 작다면 사전에 추가하기
            if (s+1 < n) {
                dic.add(currentWord.toString() + msg.charAt(s+1));
            }
            
            // 다음 단어를 위해 s + 1하기
            s++;
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}