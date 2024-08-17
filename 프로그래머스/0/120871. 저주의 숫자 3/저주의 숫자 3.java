class Solution {
    public int solution(int n) {
        int result = 0;
        
        while (n > 0) {
            result++;
            if ((""+result).contains("3") || result % 3 == 0)
                continue;
            
            n--;
            
        }
        
        return result;
    }
}