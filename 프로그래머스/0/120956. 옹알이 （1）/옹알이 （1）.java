class Solution {
    public int solution(String[] babbling) {
        int result = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        
        for (String s : babbling) {
            for (String word : words) {
                if (s.indexOf(word) > -1) {
                    s = s.replace(word, " ");
                }
            }
            if (s.trim().length() == 0) {
                result++;
            }
        }
        
        return result;
    }
}