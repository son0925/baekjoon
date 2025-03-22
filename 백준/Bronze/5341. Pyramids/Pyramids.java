import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int[] dp = new int[101];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1] + i;
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }
}