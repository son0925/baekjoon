class Solution {
    public int solution(String my_string) {
        int result = 0;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            
            if (c >= '0' && c <= '9') {
                sb.append(c);
            } 
            // 문자이고 숫자가 저장이 되어 있을 때
            else if (sb.length() > 0){
                result += Integer.valueOf(sb.toString());
                sb.setLength(0);
            }
        }
        
        if (sb.length() > 0) {
            result += Integer.valueOf(sb.toString());
        }
        
        return result;
    }
}