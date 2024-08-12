import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int result = 0;
        int n = citations.length;
        
        for (int i = 0; i < n; i++) {
            int min = Math.min(citations[i], n - i);
            result = Math.max(result, min);
        }
        
        return result;
    }
}