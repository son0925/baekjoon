import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;

    static String[][] graph;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        graph = new String[N][N];

        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().split("");
        }

        bfs();

        System.out.println(result);
    }

    public static void bfs() {
        Queue<Loc> queue = new LinkedList<>();
        queue.offer(new Loc(0, 0, 0));
        int[][] counter = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(counter[i], Integer.MAX_VALUE);
        }
        counter[0][0] = 0;

        while(!queue.isEmpty()) {
            Loc cur = queue.poll();

            int x = cur.x;
            int y = cur.y;
            int count = cur.count;

            if (x == N-1 && y == N-1) {
                result = Math.min(result, count);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!isRange(nx, ny)) continue;

                if (graph[nx][ny].equals("0") && counter[nx][ny] > count + 1) {
                    counter[nx][ny] = count+1;
                    queue.offer(new Loc(nx, ny, count + 1));
                } else if (graph[nx][ny].equals("1") && counter[nx][ny] > count) {
                    counter[nx][ny] = count;
                    queue.offer(new Loc(nx, ny, count));
                }
            }
        }
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}

class Loc {
    int x;
    int y;
    int count;

    public Loc(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}