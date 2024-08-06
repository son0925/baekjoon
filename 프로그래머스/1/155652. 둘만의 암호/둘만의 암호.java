import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            sb.append(passWordPerser(c, index, skip));
        }
        
        return sb.toString();
    }
    
    static char passWordPerser(char c, int index, String skip) {
        int count = 0;
        while (count < index) {
            
            c = (char) (c + 1);
            
            if (c > 'z')
                c = (char) (c - 26);
            
            if (!skip.contains(""+c)) 
                count++;
        }
        
        return c;
    }
}