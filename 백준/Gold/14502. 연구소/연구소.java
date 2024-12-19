import java.util.*;
import java.io.*;

public class Main {

    static int[][] map;
    static boolean[][] visit;

    static int N;
    static int M;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static List<int[]> virusList = new ArrayList<>();

    static int result = -1;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = in.nextInt();

                if (map[i][j] == 2)
                    virusList.add(new int[] {i, j});
            }
        }

        visit = new boolean[N][M];
        dfs(3);

        System.out.println(result);
    }


    public static void dfs(int count) {
        if (count == 0) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (!visit[i][j] && map[i][j] == 0) {
                    visit[i][j] = true;
                    map[i][j] = 1;
                    dfs(count-1);
                    map[i][j] = 0;
                    visit[i][j] = false;
                }

            }
        }
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>(virusList);
        boolean[][] virusVisit = new boolean[N][M];

        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();

            int x = tmp[0];
            int y = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M
                        && !virusVisit[nx][ny] && copyMap[nx][ny] == 0) {

                    copyMap[nx][ny] = 2;
                    virusVisit[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    count++;
                }
            }
        }

        result = Math.max(result, count);
    }
}