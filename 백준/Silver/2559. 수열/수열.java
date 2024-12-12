import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        int[] arr = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        dp[0] = arr[0];
        for (int i = 1; i < M; i++) {
            dp[i] = arr[i] + dp[i-1];
        }

        int max = dp[M-1];

        for (int i = M; i < N; i++) {
            dp[i] = dp[i-1] + arr[i] - arr[i - M];
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
