import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] dx = {1, 2, 1, 2, -1, -2, -1, -2};
    static int[] dy = {2, 1, -2, -1, 2, 1, -2, -1};

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            gameStart();
        }


        bw.flush();
    }

    public static void gameStart() throws IOException {
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());


        bfs(x1, y1, x2, y2, N);

    }

    public static void bfs(int startX, int startY, int endX, int endY, int N) throws IOException {
        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(startX, startY, 0));

        boolean[][] visited = new boolean[N][N];
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Loc now = queue.poll();

            int x = now.x;
            int y = now.y;
            int count = now.count;

            if (x == endX && y == endY) {
                bw.write(count + "\n");
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isRange(nx, ny, N) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Loc(nx, ny, count+1));
                }
            }
        }
    }

    public static boolean isRange(int x, int y, int N) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}

class Loc {
    int x;
    int y;
    int count;

    Loc (int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}