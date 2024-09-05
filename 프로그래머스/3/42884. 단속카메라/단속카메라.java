import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int result = 0;
        
        Arrays.sort(routes, (o1, o2) -> {
           return o1[1] - o2[1]; 
        });
        result++;
        int max = routes[0][1];
        for (int[] route : routes) {
            if (max < route[0]) {
                result++;
                max = route[1];
            }
        }
        
        return result;
    }
}