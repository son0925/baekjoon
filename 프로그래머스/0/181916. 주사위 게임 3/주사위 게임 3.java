import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] arr = {a,b,c,d};
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) +1);
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, (o1,o2) -> map.get(o2).compareTo(map.get(o1)));
        
        if (map.size() == 1) {
            return 1111 * a;
        }
        else if (map.size() == 2 && map.get(keySet.get(0)) == 3) {
            return (int)Math.pow((10 * keySet.get(0) + keySet.get(1)),2);
        }
        else if (map.size() == 2 && map.get(keySet.get(0)) == 2) {
            int n = keySet.get(0);
            int m = keySet.get(1);
            return (n+m) * Math.abs(n-m);
        }
        else if (map.size() == 3) {
            return keySet.get(1) * keySet.get(2);
        }
        return keySet.get(0);
    }
}