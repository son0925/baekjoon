import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        
        int[] dp = new int[2];
        dp[1] = 1;
        
        for (int i = 2; i <= N; i++) {
        	int tmp = dp[0];
        	dp[0] = dp[1];
        	dp[1] += tmp;
        }
        
        System.out.println(dp[1]);
    }
}