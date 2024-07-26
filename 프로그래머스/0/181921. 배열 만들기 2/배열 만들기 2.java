import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        
        String regx = "^[^12346789]*$";
        for (int i = l; i <= r; i++) {
            if (String.valueOf(i).matches(regx)) {
                list.add(i);
            }
        }
        
        if (list.size() > 0) {
            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }
        return new int[]{-1};
    }
}