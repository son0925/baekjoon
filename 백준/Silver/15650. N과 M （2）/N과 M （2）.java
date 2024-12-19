import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();

        // visit, count, sb
        boolean[] visit = new boolean[N];
        int count = 0;
        sb = new StringBuilder();
        recursion(visit, count, 0);
        System.out.println(sb);
    }

    public static void recursion(boolean[] visit, int count, int start) {

        if (count == M) {
            for (int i = 0; i < N; i++) {
                if (visit[i]) sb.append(i+1).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                recursion(visit, count+1, i);
                visit[i] = false;
            }
        }
    }
}