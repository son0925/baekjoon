import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static String[][] graph;
    static boolean[][] visited;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        N = Integer.parseInt(in.nextLine());
        graph = new String[N][N];

        for (int i = 0; i < N; i++) {
            graph[i] = in.nextLine().split("");
        }

        visited = new boolean[N][N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count++;
                    bfs(i, j, false);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append(" ");

        visited = new boolean[N][N];
        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count++;
                    bfs(i, j, true);
                }
            }
        }

        sb.append(count);
        System.out.println(sb);
    }

    public static void bfs(int x, int y, boolean isColorWeakness) {
        visited[x][y] = true;

        Queue<Loc> queue = new LinkedList<>();
        queue.offer(new Loc(x,y,isColorWeakness,graph[x][y]));

        while (!queue.isEmpty()) {
            Loc now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (isRange(nx,ny) && !visited[nx][ny] && now.isSameColor(graph[nx][ny])) {
                    visited[nx][ny] = true;
                    queue.offer(new Loc(nx, ny, isColorWeakness, now.color));
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
    boolean isColorWeakness;
    String color;

    Loc(int x, int y, boolean isColorWeakness, String color) {
        this.x = x;
        this.y = y;
        this.isColorWeakness = isColorWeakness;
        this.color = color;
    }

    boolean isSameColor(String compareColor) {
 
        if (color.equals(compareColor)) {
            return true;
        }

        if (isColorWeakness
                && ((color.equals("R") && compareColor.equals("G"))
                || (color.equals("G") && compareColor.equals("R")))) {
            return true;
        }

        return false;
    }
}