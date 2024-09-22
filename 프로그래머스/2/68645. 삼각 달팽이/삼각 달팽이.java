import java.util.*;

class Solution {
    public int[] solution(int n) {
        int max = n * (n + 1) / 2; 
        int[][] map = new int[n][n];
        int[] result = new int[max];
        
        int el = 1;
        int x = -1, y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++; 
                } else if (i % 3 == 1) {
                    y++; 
                } else {
                    x--;
                    y--;
                }
                map[x][y] = el++;
            }
        }
        
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[idx++] = map[i][j];
            }
        }
        
        return result;
    }
}