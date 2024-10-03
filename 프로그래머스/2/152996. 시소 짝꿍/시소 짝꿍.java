import java.util.*;

class Solution {
    public long solution(int[] arr) {
        double[] weights = new double[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            weights[i] = (double) arr[i];
        }
        long result = 0;
        
        Map<Double,Integer> map = new HashMap<>();
        
        for (double weight : weights) {
            map.put(weight, map.getOrDefault(weight, 0) + 1);
        }
        
        Arrays.sort(weights);
        for (double weight : weights) {
            if (map.get(weight) == 1) {
                map.remove(weight);
            } else {
                map.put(weight, map.get(weight) -1);
            }
            
            result += map.getOrDefault(weight, 0);
            result += map.getOrDefault(weight * 2, 0);
            result += map.getOrDefault(weight * 4. / 3, 0);
            result += map.getOrDefault(weight * 3. / 2, 0);
            
        }
        return result;
    }
}