import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        
        HashMap<Character,Integer> mapX = new HashMap<>();
        HashMap<Character,Integer> mapY = new HashMap<>();
        
        for (int i = 0; i < X.length(); i++) {
            mapX.merge(X.charAt(i), 1, Integer::sum);
        }
        
        for (int i = 0; i < Y.length(); i++) {
            mapY.merge(Y.charAt(i), 1, Integer::sum);
        }
        
        List<Character> keySet = new ArrayList<>(mapX.keySet());
        keySet.sort((o1, o2) -> o2 - o1);
        
        for (char key : keySet) {
            int count = Math.min(mapX.get(key), mapY.getOrDefault(key, 0));
            for (int i = 0; i < count; i++) {
                sb.append(key);
            }
        }
        
        if (sb.length() == 0) {
            return "-1";
        }
        
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}