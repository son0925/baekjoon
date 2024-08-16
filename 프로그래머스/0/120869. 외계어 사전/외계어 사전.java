import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        int[] alpha = new int[26];
        int[] checkArr = new int[26];
        
        for (char c : String.join("", spell).toCharArray()) {
            alpha[c-'a']++;
        }
        
        for (String s : dic) {
            checkArr = new int[26];
            for (char c : s.toCharArray()) {
                checkArr[c-'a']++;
            }
            if (Arrays.equals(alpha, checkArr)) {
                return 1;
            }
        }
        
        return 2;
    }
}