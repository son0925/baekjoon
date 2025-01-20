import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, S, M;
    static int[] volume;
    static int[][] dp;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        volume = new int[N];
        dp = new int[N][M+1];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            volume[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(search(0, S));
    }

    public static int search(int idx, int value) {
        if (0 > value || value > M) {
            return -1;
        }

        if (idx == N) {
            return value;
        }

        if (dp[idx][value] != Integer.MIN_VALUE) {
            return dp[idx][value];
        }

        return dp[idx][value] = Math.max(dp[idx][value],
                Math.max(search(idx+1, value + volume[idx]), search(idx+1, value-volume[idx])));
    }
}