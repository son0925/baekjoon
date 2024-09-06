import java.util.*;

class Solution {
    
    static HashSet<Integer> primeNumbers = new HashSet<>();
    
    public int solution(String numbers) {
        boolean[] visit = new boolean[numbers.length()];
        
        for (int i = 1; i <= visit.length; i++) {
            permutation(numbers, visit, 0, i, "");
        }
        
        return primeNumbers.size();
    }
    
    public void permutation(String numbers, boolean[] visit, int idx, int count, String current) {
        if (idx == count) {
            int num = Integer.parseInt(current);
            
            if (num > 1 && isPrime(num)) {
                primeNumbers.add(num);
            }
        }
        
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                permutation(numbers, visit, idx+1, count, current + numbers.charAt(i));
                visit[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n) {
        boolean result = true;
        
        for (int i = 2; i < (int) Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                result = false;
                break;
            }
        }
        
        return result;
    }
}