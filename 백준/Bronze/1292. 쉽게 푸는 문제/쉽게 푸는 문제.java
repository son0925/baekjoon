import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int count = 0;

        int start = 0;
        for (int i = 1; i <= 1000; i++) {
            count += i;

            if (n <= count) {
                start = i;
                count -= i;
                break;
            }
        }

        int result = 0;
        int cnt = 0;
        for (int i = count+1; i <= m; i++) {
            cnt++;
            if (i < n) continue;

            result += start;

            if (cnt == start) {
                cnt = 0;
                start++;
            }
        }

        System.out.println(result);
    }
}