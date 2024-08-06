import java.util.*;

class Solution {
    
    static List<String> skipList;
    
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        
        skipList = new ArrayList<>(Arrays.asList(skip.split("")));
        
        for (char c : s.toCharArray()) {
            sb.append(passWordPerser(c, index));
        }
        
        return sb.toString();
    }
    
    static char passWordPerser(char c, int index) {
        int count = 0;
        while (count < index) {
            
            c = (char) (c + 1);
            
            if (c > 'z')
                c = (char) (c - 26);
            
            if (!skipList.contains(""+c)) 
                count++;
        }
        
        return c;
    }
}