import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> set = new HashSet<>();
        
        while (n > 1) {
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    set.add(i);
                    n /= i;
                    break;
                }
            }
        }
        
        int[] result = new int[set.size()];
        int index = 0;
        Iterator iter = set.iterator();
        while (iter.hasNext()) {
            result[index++] = Integer.parseInt("" + iter.next());
        }
        
        Arrays.sort(result);
        return result;
    }
}