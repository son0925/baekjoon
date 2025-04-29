import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            int max = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int n = Integer.parseInt(st.nextToken());

                max = Math.max(max, n);
            }

            String format = "Case #%d: %d";
            System.out.println(String.format(format, i, max));
        }
    }
}