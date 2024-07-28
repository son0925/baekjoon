class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int denom = lcm(denom1, denom2);
        int numer = (denom / denom1 * numer1) + (denom / denom2 * numer2);
        
        return new int[]{numer / gcd(denom, numer), denom / gcd(denom,numer)};
    }
    
    // 최대공약수 구하는 함수
    public static int gcd(int n, int m) {
        while (m != 0) {
            int tmp = n % m;
            n = m;
            m = tmp;
        }
        return n;
    }
    
    // 최소공배수 구하는 함수
    public static int lcm(int n, int m) {
        return n * m / gcd(n,m);
    }
}