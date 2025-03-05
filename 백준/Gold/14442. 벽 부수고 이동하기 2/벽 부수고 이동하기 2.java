import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String[][] graph;

    static int result = Integer.MAX_VALUE;

    static int N;
    static int M;
    static int K;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new String[N][M];

        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().split("");
        }

        bfs();

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 1, K});

        boolean[][][] visited = new boolean[N][M][K+1];
        visited[0][0][K] = true;

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();

            int x = tmp[0];
            int y = tmp[1];
            int count = tmp[2];
            int destruction = tmp[3];

            if (x == N - 1 && y == M - 1) {
                result = Math.min(result, count);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!isRange(nx, ny)) continue;

                if (graph[nx][ny].equals("0") && !visited[nx][ny][destruction]) {
                    visited[nx][ny][destruction] = true;
                    queue.offer(new int[] {nx, ny, count+1, destruction});
                } else if (graph[nx][ny].equals("1") && destruction-1 >= 0 && !visited[nx][ny][destruction-1]) {
                    visited[nx][ny][destruction-1] = true;
                    queue.offer(new int[] {nx, ny, count+1, destruction-1});
                }
            }
        }
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}