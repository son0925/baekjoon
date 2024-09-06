import java.util.HashSet;

class Solution {
    HashSet<Integer> primeNumbers = new HashSet<>();
    
    public int solution(String numbers) {
        boolean[] visit = new boolean[numbers.length()];
        // 1자리부터 numbers 길이까지 모든 조합을 시도
        for (int i = 1; i <= numbers.length(); i++) {
            permutation(numbers, visit, 0, i, "");
        }
        
        return primeNumbers.size(); // 중복을 제거한 소수 개수
    }
    
    public void permutation(String s, boolean[] visit, int depth, int count, String current) {
        // 순열의 길이가 count만큼 되었을 때
        if (depth == count) {
            int num = Integer.parseInt(current);  // 현재 순열 문자열을 숫자로 변환
            if (num > 1 && isPrime(num)) {
                primeNumbers.add(num);  // 소수이면 HashSet에 추가 (중복 제거)
            }
            return;
        }
        
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                // 현재 선택한 문자를 추가하여 재귀 호출
                permutation(s, visit, depth + 1, count, current + s.charAt(i));
                visit[i] = false;  // 백트래킹
            }
        }
    }
    
    public boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
