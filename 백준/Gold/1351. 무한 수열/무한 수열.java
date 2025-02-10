import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Map<Long,Long> dp = new HashMap<>();

    static int P;
    static int Q;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        dp.put(0L, 1L);

        System.out.println(recursion(N));
    }

    public static long recursion(long n) {
        if (n == 0) return 1;

        if (!dp.containsKey(n)) {
            long x = (long)Math.floor(n/P);
            long y = (long)Math.floor(n/Q);

            dp.put(n, recursion(x) + recursion(y));
        }

        return dp.get(n);
    }
}