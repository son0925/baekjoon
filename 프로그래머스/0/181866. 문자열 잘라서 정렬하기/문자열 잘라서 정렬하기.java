import java.util.*;

class Solution {
    public String[] solution(String myString) {
        List<String> list = new ArrayList<>();
        for (String s : myString.split("x")) {
            if (!s.equals("")) {
                list.add(s);
            }
        }
        
        String[] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        Arrays.sort(result);
        return result;
    }
}