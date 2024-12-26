import java.io.*;
import java.util.*;

public class Main {
    static Scanner in;

    public static void main(String[] args) throws IOException {
        in = new Scanner(System.in);

        int N = in.nextInt();
        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.println(dp[N]);
    }
}