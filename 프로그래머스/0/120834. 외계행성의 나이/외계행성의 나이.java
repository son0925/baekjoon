class Solution {
    public String solution(int age) {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        
        StringBuilder sb = new StringBuilder();
        
        while (age > 0) {
            sb.append(alpha.charAt(age%10));
            age /= 10;
        }
        
        return sb.reverse().toString();
    }
}