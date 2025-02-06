import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());

        int[] counter = new int[N];

        int[][] student = new int[N][5];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                student[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][N];
        for (int k = 0; k < 5; k++) {
            int[] tmp = new int[N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j || visited[i][j]) continue;

                    if (student[i][k] == student[j][k]) {
                        visited[i][j] = true;
                        tmp[i]++;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                counter[i] += tmp[i];
            }
        }

        int max = 0;
        int idx = 1;
        for (int i = 0; i < N; i++) {
            if (max < counter[i]) {
                max = counter[i];
                idx = i+1;
            }
        }

        System.out.println(idx);
    }
}