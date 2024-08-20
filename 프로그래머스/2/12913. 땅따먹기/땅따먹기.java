import java.util.*;

class Solution {
    int solution(int[][] land) {
        int result = 0;
        
        // 1~n-1번 열을 반복
        // i - 1번의 열에서 i번째 열에 더할 수 있는 가장 큰 수를 더하는 코드
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                int max = -1;
                
                // 연속해서 접근하지 못하기 때문에 k != j
                // i-1 번의 행중 가장 큰 수를 저장하고 더하기
                for (int k = 0; k < 4; k++) {
                    if (k != j && land[i-1][k] > max) {
                        max = land[i-1][k];
                    }
                }
                land[i][j] += max;
            }
        }
        
        // 디버깅용
        // for (int i = 0; i < land.length; i++) {
        //     System.out.println(Arrays.toString(land[i]));
        // }
        
        // 마지막 열의 가장 큰수를 return하기
        for (int i = 0; i < 4; i++) {
            result = Math.max(result, land[land.length-1][i]);
        }
        return result;
    }
}