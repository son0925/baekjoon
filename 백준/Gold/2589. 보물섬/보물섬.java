import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[][] graph;
    static int N;
    static int M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new String[N][M];

        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().split("");
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j].equals("L")) {
                    int[] farthestNode = bfs(i, j);
                    int[] secondNode = bfs(farthestNode[0], farthestNode[1]);
                    max = Math.max(secondNode[2], max);
                }
            }
        }

        System.out.println(max);
    }

    public static int[] bfs(int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(new int[]{n, m, 0});
        visited[n][m] = true;

        int max = 0;
        int[] farthestNode = {n, m, 0};

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();

            int x = tmp[0];
            int y = tmp[1];
            int count = tmp[2];

            if (max < count) {
                max = count;
                farthestNode = new int[]{x, y, count};
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isRange(nx, ny) && !visited[nx][ny] && graph[nx][ny].equals("L")) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, count + 1});
                }
            }
        }

        return farthestNode;
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}