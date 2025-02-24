import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memoryArr = new int[N];
        int[] costArr = new int[N];

        arrInit(memoryArr);
        arrInit(costArr);

        int[][] dp = new int[N+1][100001];

        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int memory = memoryArr[i-1];
            int cost = costArr[i-1];

            for (int j = 0; j < 100001; j++) {
                if (j - cost >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - cost] + memory);
                }

                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);

                if (dp[i][j] >= M) {
                    result = Math.min(result, j);
                }
            }
        }

        if (result == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }

    }

    public static void arrInit(int[] arr) throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}