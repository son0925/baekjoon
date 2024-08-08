class Solution {
    public String solution(String my_string) {
        String result = "";
        
        for (int i = 0; i < my_string.length(); i++) {
            String s = "" + my_string.charAt(i);
            
            if (!result.contains(s)) {
                result += s;
            }
        }
        
        return result;
    }
}