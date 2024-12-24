import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int N = Integer.parseInt(in.nextLine());

        int[] times = new int[N+1];
        int[] pays = new int[N+1];
        int[] dp = new int[N+2];
        int max = 0;

        String[] tmp;
        for (int i = 1; i <= N; i++) {
            tmp = in.nextLine().split(" ");

            times[i] = Integer.parseInt(tmp[0]);
            pays[i] = Integer.parseInt(tmp[1]);
        }


        for (int i = 1; i <= N+1; i++) {
            dp[i] = Math.max(max, dp[i]);

            if (i <= N && i + times[i] <= N+1) {
                dp[i + times[i]] = Math.max(dp[i + times[i]], dp[i] + pays[i]);
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}