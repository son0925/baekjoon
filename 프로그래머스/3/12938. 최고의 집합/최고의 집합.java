import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] result = new int[n];
        
        if (n > s) {
            return new int[]{-1};
        }
        
        Arrays.fill(result, s / n);
        if (s % n != 0) {
            int remainder = s % n;
            for (int i = n-1; remainder > 0; i--) {
                result[i]++;
                remainder--;
            }
        }
        
        return result;
    }
}