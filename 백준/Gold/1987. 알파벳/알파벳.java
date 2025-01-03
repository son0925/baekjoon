import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static char[][] graph;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static boolean[][] visited;
    static boolean[] alpha;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int result = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graphInit();

        visited[0][0] = true;
        alpha[graph[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(result);
    }

    public static void dfs(int x, int y, int count) {

        result = Math.max(result, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isRange(nx, ny) && !visited[nx][ny] && !alpha[graph[nx][ny] - 'A']) {
                visited[nx][ny] = true;
                alpha[graph[nx][ny] - 'A'] = true;
                dfs(nx, ny, count + 1);
                visited[nx][ny] = false;
                alpha[graph[nx][ny] - 'A'] = false;
            }
        }

    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    public static void graphInit() throws IOException {
        graph = new char[N][M];
        visited = new boolean[N][M];
        alpha = new boolean[26];

        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().toCharArray();
        }
    }
}