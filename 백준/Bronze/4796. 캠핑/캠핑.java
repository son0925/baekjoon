import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int cnt = 1;
        while(!(P == 0 && L == 0 && V == 0)) {
            int div = V / P * L;
            int rem = Math.min(V % P, L);
            sb.append(String.format("Case %d: %d", cnt++, div + rem)).append("\n");

            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
        }

        System.out.println(sb);
    }
}