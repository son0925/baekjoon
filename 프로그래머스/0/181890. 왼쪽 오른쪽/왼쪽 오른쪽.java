import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        List<String> list = new ArrayList<>();
        
        int s = 0;
        int e = 0;
        for (int i = 0; i < str_list.length; i++) {
            if (str_list[i].equals("l")) {
                e = i;
                break;
            } else if (str_list[i].equals("r")) {
                s = i + 1;
                e = str_list.length;
                break;
            }
        }
        
        String[] result = new String[e-s];
        
        int index = 0;
        for (int i = s; i < e; i++) {
            result[index++] = str_list[i];
        }
        
        return result;
    }
}