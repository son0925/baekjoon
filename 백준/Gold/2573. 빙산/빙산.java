import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int M;

    static int[][] graph;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static Queue<Loc> iceberg = new LinkedList<>();
    static List<Loc> tmp = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();

        int year = 0;

        while (true) {
            int piece = condition();

            if (piece == 0) {
                year = 0;
                break;
            } else if (piece > 1) {
                break;
            }

            year++;
            meltingIce();
            optimization();
        }

        System.out.println(year);
    }

    public static void optimization() {
        for (Loc ice : tmp) {
            graph[ice.x][ice.y] -= ice.count;

            if (graph[ice.x][ice.y] <= 0) {
                graph[ice.x][ice.y] = 0;
            } else {
                iceberg.offer(new Loc(ice.x, ice.y));
            }
        }

        tmp = new ArrayList<>();
    }

    public static int condition() {
        boolean[][] visited = new boolean[N][M];

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && graph[i][j] > 0) {
                    count++;
                    bfs(i, j, visited);
                }
            }
        }

        return count;
    }

    public static void bfs(int x, int y, boolean[][] visited) {
        Queue<Loc> queue = new LinkedList<>();
        queue.offer(new Loc(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Loc now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (isRange(nx, ny) && !visited[nx][ny] && graph[nx][ny] > 0) {
                    visited[nx][ny] = true;
                    queue.offer(new Loc(nx, ny));
                }
            }


        }
    }

    public static void meltingIce() {
        while(!iceberg.isEmpty()) {
            Loc ice = iceberg.poll();

            int count = 0;
            for (int i = 0; i < 4; i++) {
                int nx = ice.x + dx[i];
                int ny = ice.y + dy[i];

                if (isRange(nx, ny) && graph[nx][ny] == 0) {
                    count++;
                }
            }

            tmp.add(new Loc(ice.x, ice.y, count));
        }
    }


    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                if (graph[i][j] > 0) {
                    iceberg.offer(new Loc(i, j));
                }
            }
        }

    }


    public static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}

class Loc {
    int x, y, count;

    public Loc(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Loc(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

    @Override
    public String toString() {
        return "x: " + x + " y: " + y;
    }
}