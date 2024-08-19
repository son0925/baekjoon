import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long result = 0;
        int m = works.length-1;
        Arrays.sort(works);
        while (n > 0) {
            sortedArr(works, m);
            works[m]--;
            n--;
        }
        
        for (int i = 0; i < works.length; i++) {
            if (works[i] > 0) {
                result += works[i] * works[i];
            }
        }
        return result;
    }
    
    public static void sortedArr(int[] works, int m) {
        if (m == 0) {
            return;
        }
        
        for (int i = m; i >= 0; i--) {
            boolean isSwap = false;
            int target = works[i];
            int j = i-1;
            while (j >= 0 && target < works[j]) {
                works[j+1] = works[j];
                j--;
                isSwap = true;
            }
            works[j+1] = target;
            if (!isSwap) {
                break;
            }
        }
        return;
    }
}