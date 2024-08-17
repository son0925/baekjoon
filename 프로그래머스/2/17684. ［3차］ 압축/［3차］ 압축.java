import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // 초기 사전 설정
        String[] initialWords = {"", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        List<String> dictionary = new ArrayList<>(Arrays.asList(initialWords));
        List<Integer> list = new ArrayList<>();
        
        int n = msg.length();
        int s = 0;

        while (s < n) {
            StringBuilder currentWord = new StringBuilder();
            currentWord.append(msg.charAt(s));
            
            // 현재 문자열이 사전에 있는 동안 계속 확장
            while (s + 1 < n && dictionary.contains(currentWord.toString() + msg.charAt(s + 1))) {
                currentWord.append(msg.charAt(++s));
            }
            
            // 사전에 있는 문자열의 인덱스 추가
            list.add(dictionary.indexOf(currentWord.toString()));
            
            // 현재 문자열을 사전에 추가
            if (s + 1 < n) {
                dictionary.add(currentWord.toString() + msg.charAt(s + 1));
            }
            
            s++; // 다음 문자로 이동
        }
        
        // 결과를 배열로 변환
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
