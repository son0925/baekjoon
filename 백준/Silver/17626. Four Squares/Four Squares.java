import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int result = Integer.MAX_VALUE;

    static Integer[] dp = new Integer[50001];

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        Arrays.fill(dp, 1_000_000);
        for (int i = 1; i < (int) Math.sqrt(50000); i++) {
            dp[i*i] = 1;
        }
        System.out.println(recursion(N));
    }

    public static int recursion(int n) {
        if (dp[n] < 1_000_000) {
            return dp[n];
        }

        for (int i = (int) Math.sqrt(n); i > 0; i--) {
            dp[n] = Math.min(dp[n], recursion(n - i * i) + 1);
        }

        return dp[n];
    }
}