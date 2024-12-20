import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[input.length()][26];
        dp[0][input.charAt(0) - 'a'] = 1;
        for (int i = 1; i < input.length(); i++) {
            int alphaIdx = input.charAt(i) - 'a';
            dp[i][alphaIdx] = 1;
            for (int j = 0; j < 26; j++) {
                dp[i][j] += dp[i - 1][j];
            }
        }

        for (int i = 0; i < T; i++) {
            String[] tmp = br.readLine().split(" ");
            int target = tmp[0].charAt(0) - 'a';
            int start = Integer.parseInt(tmp[1]);
            int end = Integer.parseInt(tmp[2]);

            if (start == 0) {
                sb.append(dp[end][target]).append("\n");
            } else {
                sb.append(dp[end][target] - dp[start - 1][target]).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}