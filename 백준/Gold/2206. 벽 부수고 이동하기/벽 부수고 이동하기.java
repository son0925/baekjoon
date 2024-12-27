import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] graph;

    static int min = Integer.MAX_VALUE;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");

            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }

        bfs();

        if (min == Integer.MAX_VALUE) {
            bw.write("" +-1);
        } else {
            bw.write("" + min);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs() {
        Queue<Loc> queue = new LinkedList<>();
        queue.offer(new Loc(0,0));

        // x, y, (분기점 0 : 벽을 부수지 않았을 때 방문 했는지, 1 : 벽을 부쉈을 때 방문했는지)
        boolean[][][] visited = new boolean[N][M][2];

        while (!queue.isEmpty()) {
            Loc now = queue.poll();

            if (now.isArrived(N,M)) {
                min = Math.min(min, now.count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                int nextCount = now.count + 1;
                // 벽이 아닐 때
                if (graph[nx][ny] == 0) {
                    // 파괴하지 않았고 파괴하지 않은 분기에서 방문하지 않았을 때
                    if (!now.destroyed && !visited[nx][ny][0]) {
                        queue.offer(new Loc(nx, ny, nextCount, false));
                        visited[nx][ny][0] = true;
                    }
                    // 파괴를 한 적이 있고 파괴했는 분기에서 방문하지 않았을 때
                    else if (now.destroyed && !visited[nx][ny][1]) {
                        queue.offer(new Loc(nx, ny, nextCount, true));
                        visited[nx][ny][1] = true;
                    }
                }
                // 벽이라면 벽을 부순 적이 없을 때 부순다.
                else if (!now.destroyed){
                    queue.offer(new Loc(nx, ny, nextCount, true));
                    visited[nx][ny][1] = true;
                }
            }
        }
    }
}

class Loc {
    int x;
    int y;
    int count;
    boolean destroyed;

    public Loc(int x, int y) {
        this.x = x;
        this.y = y;
        this.count = 1;
        this.destroyed = false;
    }

    public Loc(int x, int y, int count, boolean destroyed) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.destroyed = destroyed;
    }

    public boolean isArrived(int n, int m) {
        return x == n-1 && y == m-1;
    }

    @Override
    public String toString() {
        return "현재 위치 : " + x + " " + y + "\n"
                + "이동 횟수 : " + count + "\n"
                + "파괴 가능 여부 : " + destroyed;
    }
}