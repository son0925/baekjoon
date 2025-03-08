import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static long[] dp;
    static long[] arr;

    static int N;

    static long result = 0;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            Main.solution();
        }

        System.out.println(result);
        System.out.println(sb);
    }

    /**
     * 제일 큰 숫자의 idx 찾기
     * 이 때 제일 큰 수가 2개 이상이라면 첫 번째로 찾은 idx 저장
     * 가장 큰 누적합이 나오는 범위 찾기
     */

    public static void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new long[N+1];
        arr = new long[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = arr[1];
        long max = dp[1];
        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }


        result += max;

        // 좌표 찾기
        int l = -10001;
        int r = 10001;

        for (int i = 1; i <= N; i++) {
            if (dp[i] == max) {
                long sum = 0;
                for (int j = i; j > 0; j--) {
                    sum += arr[j];

                    if (sum == max) {

                        if (Math.abs(r - l) > Math.abs(i - j)) {
                            r = i;
                            l = j;
                        }
                        break;
                    }
                }
            }
        }

        sb.append(l).append(" ").append(r).append("\n");
    }
}