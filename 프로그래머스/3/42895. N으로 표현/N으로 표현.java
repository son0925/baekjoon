import java.util.*;

class Solution {
    public int solution(int N, int number) {
        HashMap<Integer,Integer> map = initMap(N);
        // map, N, current, count
        counting(map, N, 0, 0);
        return map.getOrDefault(number, -1);
    }
    
    void counting(HashMap<Integer,Integer> map, int N, int current, int count) {
        if (count > 8 || (count > 0 && current == 0)) {
            return;
        }
        
        map.put(current, Math.min(count, map.getOrDefault(current, count)));
        
        for (int i = N, digit = 1; i <= 111111111; i = i * 10 + N, digit++) {
            counting(map, N, current+i, count+digit);
            counting(map, N, current-i, count+digit);
            counting(map, N, current*i, count+digit);
            counting(map, N, current/i, count+digit);
        }
    }
    
    HashMap<Integer,Integer> initMap(int N) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for (int i = N, count = 1; i <= 111111111; i = i * 10 + N, count++) {
            map.put(i, count);
        }
        
        return map;
    }
}