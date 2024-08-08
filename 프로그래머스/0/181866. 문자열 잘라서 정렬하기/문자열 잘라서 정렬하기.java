import java.util.*;

class Solution {
    public String[] solution(String myString) {
        StringTokenizer st = new StringTokenizer(myString, "x");
        int n = st.countTokens();
        String[] result = new String[n];
        
        for (int i = 0; i < n; i++) {
            result[i] = st.nextToken();
        }
        
        Arrays.sort(result);
        
        return result;
    }
}