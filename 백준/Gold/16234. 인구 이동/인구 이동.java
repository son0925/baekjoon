import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[][] graph;
    static boolean[][] visited;

    static int N;
    static int L;
    static int R;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int result = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graphInit();

        while (true) {
            visited = new boolean[N][N];
            boolean isChanged = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            isChanged = true;
                        }
                    }
                }
            }

            if (!isChanged) break;
            result++;
        }

        System.out.println(result);
    }

    public static boolean bfs(int x, int y) {
        Queue<Location> queue = new LinkedList<>();
        List<Location> union = new ArrayList<>();
        int sum = 0;

        queue.offer(new Location(x, y));
        visited[x][y] = true;
        union.add(new Location(x, y));
        sum += graph[x][y];

        while (!queue.isEmpty()) {
            Location now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (isRange(nx, ny) && !visited[nx][ny]) {
                    int diff = Math.abs(graph[nx][ny] - graph[now.x][now.y]);
                    if (L <= diff && diff <= R) {
                        visited[nx][ny] = true;
                        queue.offer(new Location(nx, ny));
                        union.add(new Location(nx, ny));
                        sum += graph[nx][ny];
                    }
                }
            }
        }

        if (union.size() > 1) {
            int avg = sum / union.size();
            for (Location loc : union) {
                graph[loc.x][loc.y] = avg;
            }
            return true;
        }
        return false;
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    public static void graphInit() throws IOException {
        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

class Location {
    int x;
    int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}