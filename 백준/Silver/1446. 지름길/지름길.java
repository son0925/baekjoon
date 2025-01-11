import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<Shortcut> shortcuts = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            if (end > D) continue;

            shortcuts.add(new Shortcut(start, end, length));
        }

        int[] dp = new int[D + 1];
        for (int i = 0; i <= D; i++) {
            dp[i] = i;
        }

        for (int i = 0; i <= D; i++) {
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }

            for (Shortcut shortcut : shortcuts) {
                if (shortcut.start == i) { 
                    dp[shortcut.end] = Math.min(dp[shortcut.end], dp[i] + shortcut.length);
                }
            }
        }

        System.out.println(dp[D]);
    }
}

class Shortcut {
    int start, end, length;

    public Shortcut(int start, int end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }
}