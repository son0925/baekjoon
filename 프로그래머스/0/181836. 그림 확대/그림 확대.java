class Solution {
    public String[] solution(String[] picture, int k) {
        String[] result = new String[picture.length * k];
        int index = 0;
        
        for (int i = 0; i < picture.length; i++) {
            String s = picture[i];
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < s.length(); j++) {
                for (int n = 0; n < k; n++) {
                    sb.append(s.charAt(j));
                }
            }
            
            for (int j = 0; j < k; j++) {
                result[index++] = sb.toString();
            }
        }
        
        return result;
    }
}