import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static final int MOD = 9901;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[100001];
        dp[0] = 1;
        dp[1] = 3;

        for (int i = 2; i <= 100000; i++) {
            dp[i] = (2 * dp[i-1] + dp[i-2]) % MOD;
        }

        System.out.println(dp[N]);
    }
}