class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();

        int nowNumber = 0;
        int turn = 0;
        while (sb.length() < t) {
            String num = getNumberOfNthDigit(n, nowNumber);
            for (char c : num.toCharArray()) {
                if (sb.length() >= t) {
                    break;
                }
                if (turn == p - 1) { // p번째 플레이어의 차례가 맞는지 확인
                    sb.append(c);
                }
                turn = (turn + 1) % m;
            }
            nowNumber++;
        }

        return sb.toString();
    }

    static String getNumberOfNthDigit(int base, int num) {
        if (num == 0) {
            return "0"; // num이 0인 경우를 처리
        }

        StringBuilder sb = new StringBuilder();
        String[] alpha = {"A", "B", "C", "D", "E", "F"};

        while (num > 0) {
            int n = num % base;
            if (n >= 10) {
                sb.append(alpha[n - 10]); // 10 이상인 경우 A-F로 변환
            } else {
                sb.append(n);
            }
            num = num / base;
        }

        return sb.reverse().toString();
    }
}
