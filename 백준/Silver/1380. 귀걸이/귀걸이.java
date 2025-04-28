import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int count = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            String[] students = new String[N];
            for (int i = 0; i < N; i++) {
                students[i] = br.readLine();
            }

            int[] counter = new int[N];
            for (int i = 0; i < N * 2 - 1; i++) {
                st = new StringTokenizer(br.readLine());

                int idx = Integer.parseInt(st.nextToken());
                counter[idx-1]++;
            }

            for (int i = 0; i < N; i++) {
                if (counter[i] == 1) {
                    sb.append(count++).append(" ").append(students[i]).append("\n");
                }
            }

        }

        System.out.println(sb);
    }
}