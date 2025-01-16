import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Integer[][] dp;
    static int[] W;
    static int[] V;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new Integer[N][K+1];
        W = new int[N];
        V = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(recursion(N-1, K));
    }

    public static int recursion(int i, int k) {
        if (i < 0) {
            return 0;
        }

        if (dp[i][k] != null) {
            return dp[i][k];
        }


        if (W[i] > k) {
            return dp[i][k] = recursion(i - 1, k);
        }

        return dp[i][k] = Math.max(recursion(i - 1, k), recursion(i - 1, k - W[i]) + V[i]);
    }
}