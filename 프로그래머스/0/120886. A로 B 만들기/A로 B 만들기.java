import java.util.*;

class Solution {
    public int solution(String before, String after) {
        int[] beforeCount = new int[26];
        int[] afterCount = new int[26];
        
        for (char c : before.toCharArray()) {
            beforeCount[c - 'a']++;
        } 
        
        for (char c : after.toCharArray()) {
            afterCount[c - 'a']++;
        }
        
        if (Arrays.equals(beforeCount, afterCount))
            return 1;
        return 0;
    }
}