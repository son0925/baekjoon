import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int result = 0;
        int n = citations.length;
        Arrays.sort(citations);
        int maxNum = citations[n-1];
        
        for (int h = maxNum; h > 0; h--) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (citations[i] >= h) {
                    count++;
                }
            }
            
            if (count >= h && n - count <= h) {
                result = h;
                return result;
            }
        }
        
        return result;
    }
}