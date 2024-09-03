import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int result = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        int aIdx = 0;
        int bIdx = 0;
        
        while (bIdx < B.length) {
            if (A[aIdx] < B[bIdx]) {
                result++;
                aIdx++;
            } 
            bIdx++;
        }
        
        return result;
    }
}