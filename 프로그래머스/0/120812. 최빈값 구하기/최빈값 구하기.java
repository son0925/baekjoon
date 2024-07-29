import java.util.*;

class Solution {
    public int solution(int[] array) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : array) {
            map.merge(n, 1, Integer::sum);
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1,o2) -> map.get(o2).compareTo(map.get(o1)));
        
        // size가 1이라면 바로 리턴
        if (keySet.size() == 1) {
            return keySet.get(0);
        }
        
        // 최빈값이 여러개 일 때 -1 리턴
        else if (map.get(keySet.get(0)) == map.get(keySet.get(1))) {
            return -1;
        }
        
        // 최빈값 리턴
        return keySet.get(0);
    }
}