class Solution {
    boolean solution(String s) {
        int p = 0, y = 0;
        
        for (char c : s.toLowerCase().toCharArray()) {
            if (c == 'p')
                p++;
            else if (c == 'y')
                y++;
        }
        
        return p == y;
    }
}