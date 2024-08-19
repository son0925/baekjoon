import java.util.*;

class Solution {
    
    public static List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        dfs("");
        return list.indexOf(word);
    }
    
    public static void dfs(String s) {
        if (s.length() > 5) {
            return;
        }
        list.add(s);
        for (int i = 0; i < 5; i++) {
            dfs(s + "AEIOU".charAt(i));
        }
    }
}