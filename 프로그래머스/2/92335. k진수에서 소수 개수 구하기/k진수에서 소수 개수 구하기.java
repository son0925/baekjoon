import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int result = 0;
        String num = getNthDecimal(n, k);
        
        String[] arr = num.split("0");
        
        for (String s : arr) {
            if (!s.isBlank() && isPrimeNumber(Long.parseLong(s))) {
                result++;
            }
        }
        return result;
    }
    
    public boolean isPrimeNumber(long num) {
        if (num == 1) return false;
        for (int i = 2; i < (int)Math.sqrt(num)+1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public String getNthDecimal(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        if (n < k) {
            return ""+n;
        }
        
        while (n >= k) {
            sb.append(n % k);
            n /= k;
        }
        sb.append(n);
        
        return sb.reverse().toString();
    }
}