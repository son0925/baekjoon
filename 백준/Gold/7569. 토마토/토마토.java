import java.io.*;
import java.util.*;

public class Main {
    static Scanner in;

    static int N;
    static int M;
    static int F;

    static int[][][] graph;

    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static final Queue<int[]> queue = new LinkedList<>();
    static final Queue<int[]> changeQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();
        F = in.nextInt();

        graphInit();

        int count = 0;
        while (true) {
            bfs();

            if (changeQueue.isEmpty()) {
                break;
            }

            count++;
            queue.addAll(changeQueue);
            changeQueue.clear();
        }

        if (isAllEven()) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }

    public static boolean isAllEven() {
        for (int i = 0; i < F; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (graph[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            int x = point[0];
            int y = point[1];
            int z = point[2];

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (isAble(nx, ny, nz)) {
                    changeQueue.offer(new int[] {nx, ny, nz});
                    graph[nx][ny][nz] = 1;
                }
            }
        }
    }

    public static boolean isAble(int x, int y, int z) {
        return x >= 0 && y >= 0 && z >= 0 && x < F && y < M && z < N
                && graph[x][y][z] == 0;
    }


    public static void graphInit() {
        graph = new int[F][M][N];

        for (int i = 0; i < F; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    graph[i][j][k] = in.nextInt();

                    if (graph[i][j][k] == 1) {
                        queue.offer(new int[] {i,j,k});
                    }
                }
            }
        }
    }
}