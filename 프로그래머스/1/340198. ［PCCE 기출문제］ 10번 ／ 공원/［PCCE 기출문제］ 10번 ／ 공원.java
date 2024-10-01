import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int result = -1;
        
        Arrays.sort(mats);
        int n = park.length;
        int m = park[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (park[i][j].equals("-1")) {
                    result = Math.max(getMaxSize(mats, park, i, j), result);
                    
                    if (result == mats[mats.length-1])
                        return result;
                }
            }
        }
        
        return result;
    }
    
    public int getMaxSize(int[] mats, String[][] park, int x, int y) {
        int maxSize = -1;
        int n = park.length;
        int m = park[0].length;
        
        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];
            
            boolean flag = true;
            
            if (x+size-1 >= n || y+size-1 >= m)
                continue;
            
            for (int j = x; j < x + size; j++) {
                for (int k = y; k < y + size; k++) {
                    if (!park[j][k].equals("-1")) {
                        flag = false;
                        break;
                    }
                }
            }
            
            if (flag) {
                maxSize = size;
                break;
            }
        }
        
        if (maxSize == 5) System.out.println(x + " " + y);
        
        return maxSize;
    }
}