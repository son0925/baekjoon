class Solution {
    public int solution(int n) {
        int result = 1;
        
        int num = 1;
        int fact = 1;
        
        while (n > fact) {
            num++;
            fact *= num;
            result++;
        }
        
        if (n == fact) {
            return result;
        }
        
        return result-1;
    }
}