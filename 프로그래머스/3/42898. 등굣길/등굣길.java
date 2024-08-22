import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m][n];
        
        for (int[] puddle : puddles) {
            map[puddle[0]-1][puddle[1]-1] = -1;
        }
        
        // 0번째 col를 1로 채우기 (이때 현재 길이 웅덩이거나 전의 길이 웅덩이가 있다면 -1)
        for (int i = 1; i < m; i++) {
            if (map[i][0] != -1 && map[i-1][0] != -1) {
                map[i][0] = 1;
            } else {
                map[i][0] = -1;
            }
        }
        
        // 0번째 row를 1로 채우기 (이때 현재 길이 웅덩이거나 전의 길이 웅덩이가 있다면 -1)
        for (int j = 1; j < n; j++) {
            if (map[0][j] != -1 && map[0][j-1] != -1) {
                map[0][j] = 1;
            } else {
                map[0][j] = -1;
            }
        }
        
        // 현재 위치[i][j] 왼쪽, 윗쪽의 숫자를 더하기
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 현재 위치가 웅덩이라면 continue;
                if (map[i][j] == -1) continue;
                
                // map의 크기를 넘지않고 왼쪽 길이 웅덩이가 아니라면 + 하기
                if (j-1 >= 0 && map[i][j-1] != -1) {
                    map[i][j] += map[i][j-1];
                }
                
                // map의 크기를 넘지않고 윗쪽 길이 웅덩이가 아니라면 + 하기
                if (i-1 >= 0 && map[i-1][j] != -1) {
                    map[i][j] += map[i-1][j];
                }
                map[i][j] %= 1000000007;
            }
        }
        
        if (map[m-1][n-1] == -1) return 0;
        return map[m-1][n-1];
    }
}