import java.util.*;
import java.io.*;

public class Main {
    static int n;
    
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        
        n = in.nextInt();
        int[] arr = new int[n + 1];  // 포도주 양 배열
        int[] dp = new int[n + 1];   // DP 배열
        
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }
        
        dp[1] = arr[1];
        if (n >= 2) dp[2] = arr[1] + arr[2];
        if (n >= 3) dp[3] = Math.max(dp[2], Math.max(arr[1] + arr[3], arr[2] + arr[3]));
        
        for (int i = 4; i <= n; i++) {
        	dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]));
        }
        
        // 최댓값 출력
        System.out.println(dp[n]);
    }
}