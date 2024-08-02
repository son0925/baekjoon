class Solution {
    public int[] solution(String my_string) {
        int[] result = new int[52];
        
        for (int i = 0; i < my_string.length();i++) {
            if (my_string.charAt(i) < 'a') {
                result[my_string.charAt(i)-'A']++;
            } else {
                result[my_string.charAt(i) - 'a' + 26] ++;
            }
        }
        return result;
    }
}