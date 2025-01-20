import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] graph;
    static int N;
    static final int INF = 100_000_000;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int V = Integer.parseInt(br.readLine());

        graphInit(V);
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        print();
    }

    public static void print() throws IOException {
        for (int i = 1; i <= N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] < INF)
                    sb.append(graph[i][j]).append(" ");
                else
                    sb.append(0).append(" ");
            }
            bw.write(sb.toString().trim() + "\n");
        }

        bw.flush();
    }

    public static void graphInit(int v) throws IOException {
        graph = new int[N+1][N+1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 0; i <= N; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v1][v2] = Math.min(graph[v1][v2], cost);
        }
    }
}