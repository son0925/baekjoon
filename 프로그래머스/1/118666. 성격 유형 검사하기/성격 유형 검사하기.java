import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        // 각 성격 유형 쌍의 점수를 저장하기 위한 맵
        HashMap<Character, Integer> scores = new HashMap<>();
        String result = "";
        
        // 성격 유형 초기화
        char[][] keyArr = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        
        for (char[] key : keyArr) {
            scores.put(key[0], 0);
            scores.put(key[1], 0);
        }
        
        for (int i = 0; i < survey.length; i++) {
            char first = survey[i].charAt(0);  // 첫 번째 성격 유형
            char second = survey[i].charAt(1); // 두 번째 성격 유형
            int choice = choices[i];
            
            // choice 값이 4보다 크면 두 번째 성격 유형에 점수, 4보다 작으면 첫 번째 성격 유형에 점수
            if (choice > 4) {
                scores.put(second, scores.get(second) + (choice - 4));
            } else if (choice < 4) {
                scores.put(first, scores.get(first) + (4 - choice));
            }
        }
        
        // 각 성격 유형 쌍에서 더 높은 점수를 가진 성격 유형을 결과에 추가
        for (char[] key : keyArr) {
            if (scores.get(key[0]) >= scores.get(key[1])) {
                result += key[0];
            } else {
                result += key[1];
            }
        }
        
        return result;
    }
}
