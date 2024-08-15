import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        
        while (n > 1) {
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    n /= i;
                    if (!list.contains(i)) {
                        list.add(i);
                    }
                    break;
                }
            }
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}