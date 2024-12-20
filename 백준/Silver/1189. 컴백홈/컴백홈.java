import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] visit;
    static String[][] graph;
    static int N;
    static int M;
    static int K;

    static int result = 0;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = in.nextInt();
        M = in.nextInt();
        K = in.nextInt();
        in.nextLine();

        graph = new String[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            graph[i] = in.nextLine().split("");
        }

        visit[N-1][0] = true;
        dfs(N-1, 0, 1);
        System.out.println(result);
    }

    public static void dfs(int x, int y, int steps) {
        // 목적지에 도착했을 때
        if (x == 0 && y == M-1) {
            if (steps == K) {
                result++;
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isAble(nx, ny, steps)) {
                visit[nx][ny] = true;
                dfs(nx, ny, steps +1);
                visit[nx][ny] = false;
            }
        }
    }

    // 범위를 넘지 않고 방문하지 않았으며 벽이 아닐 때
    public static boolean isAble(int x, int y, int steps) {
        return x >= 0 && y >= 0 && x < N && y < M
                && !visit[x][y]
                && graph[x][y].equals(".")
                && steps < K;
    }
}