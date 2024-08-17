class Solution {
    public int solution(int a, int b) {
        // 기약 분수 만들기(분모만 바꾸어도 상관없음 유한소수인지 판별이기 때문)
        b /= gcd(a,b);
        
        
        if (factorize(b))
            return 1;
        return 2;
    }
    
    // 기약분수로 만들기 위해 최대공약수 구하기
    static int gcd(int a, int b) {
        int minNum = Math.min(a,b);
        
        for (int i = minNum; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        
        return 1;
    }
    
    // 소인수분해를 했을 때 2,5 이외의 숫자가 나누어진다면 false
    static boolean factorize(int n) {
        boolean result = true;
        
        while (n > 1) {
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    n /= i;
                    if (i != 2 && i != 5)
                        result = false;
                    break;
                }
            }
        }
        return result;
    }
}