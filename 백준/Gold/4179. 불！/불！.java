import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String[][] graph;

    static int N;
    static int M;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static boolean[][] visited;

    static Queue<Loc> fireLoc = new LinkedList<>();
    static Queue<Loc> queue= new LinkedList<>();

    static boolean flag = true;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new String[N][M];

        Loc cur = null;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < M; j++) {
                graph[i][j] = String.valueOf(input.charAt(j));

                if (input.charAt(j) == 'F') {
                    fireLoc.add(new Loc(i, j));
                } else if (input.charAt(j) == 'J') {
                    cur = new Loc(i, j);
                    graph[i][j] = ".";
                }
            }
        }

        if (cur == null) {
            throw new RuntimeException();
        }

        visited = new boolean[N][M];
        visited[cur.x][cur.y] = true;
        queue.offer(cur);

        int cnt = 0;
        while (!queue.isEmpty() && flag) {
            cnt++;
            spreadOfFire();
            bfs();
        }

        if (flag) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(cnt);
        }
    }

    public static void bfs() {
        Queue<Loc> tmpLoc = new LinkedList<>();
        while(!queue.isEmpty()) {
            Loc cur = queue.poll();

            int x = cur.x;
            int y = cur.y;

            if (isPossible(x, y)) {
                flag = false;
                return;
            }

            // 지훈이 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isRange(nx, ny) && !visited[nx][ny] && graph[nx][ny].equals(".")) {
                    tmpLoc.offer(new Loc(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        queue.addAll(tmpLoc);
    }

    public static void print() {
        for (String[] arr : graph) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();
    }

    public static void spreadOfFire() {
        Queue<Loc> tmp = new LinkedList<>();

        while(!fireLoc.isEmpty()) {
            Loc fire = fireLoc.poll();

            for (int i = 0; i < 4; i++) {
                int nx = fire.x + dx[i];
                int ny = fire.y + dy[i];

                if (isRange(nx, ny) && graph[nx][ny].equals(".")) {
                    tmp.offer(new Loc(nx, ny));
                    graph[nx][ny] = "F";
                }
            }
        }

        fireLoc.addAll(tmp);
    }

    public static boolean isPossible(int x, int y) {
        if (x == 0 || y == 0) {
            return true;
        }

        if (x == N - 1 || y == M - 1) {
            return true;
        }

        return false;
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}

class Loc {
    int x, y;

    public Loc(int x, int y) {
        this.x = x;
        this.y = y;
    }
}