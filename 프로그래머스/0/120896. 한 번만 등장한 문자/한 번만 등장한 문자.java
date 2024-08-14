class Solution {
    public String solution(String s) {
        int[] alphaIndex = new int[26];
        
        for (char c : s.toCharArray()) {
            alphaIndex[c-'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < alphaIndex.length; i++) {
            if (alphaIndex[i] == 1) {
                sb.append((char)('a'+i));
            }
        }
        
        return sb.toString();
    }
}