import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Position redStart, blueStart;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j);
                if (map[i][j] == 'R') redStart = new Position(i, j);
                else if (map[i][j] == 'B') blueStart = new Position(i, j);
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(redStart, blueStart, 0));
        visited[redStart.x][redStart.y][blueStart.x][blueStart.y] = true;

        while (!queue.isEmpty()) {
            State state = queue.poll();

            if (state.moves >= 10) return -1;

            for (int d = 0; d < 4; d++) {
                MoveResult red = move(state.red.x, state.red.y, d);
                MoveResult blue = move(state.blue.x, state.blue.y, d);

                if (blue.inHole) continue;
                if (red.inHole) return state.moves + 1;

                if (red.x == blue.x && red.y == blue.y) {
                    if (red.dist > blue.dist) {
                        red.x -= dx[d];
                        red.y -= dy[d];
                    } else {
                        blue.x -= dx[d];
                        blue.y -= dy[d];
                    }
                }

                if (!visited[red.x][red.y][blue.x][blue.y]) {
                    visited[red.x][red.y][blue.x][blue.y] = true;
                    queue.add(new State(
                            new Position(red.x, red.y),
                            new Position(blue.x, blue.y),
                            state.moves + 1));
                }
            }
        }

        return -1;
    }

    static MoveResult move(int x, int y, int dir) {
        int dist = 0;
        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (map[nx][ny] == '#') break;
            x = nx;
            y = ny;
            dist++;
            if (map[x][y] == 'O') return new MoveResult(x, y, dist, true);
        }
        return new MoveResult(x, y, dist, false);
    }

    static class MoveResult {
        int x, y, dist;
        boolean inHole;

        MoveResult(int x, int y, int dist, boolean inHole) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.inHole = inHole;
        }
    }
}

class Position {
    int x, y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class State {
    Position red, blue;
    int moves;

    State(Position red, Position blue, int moves) {
        this.red = red;
        this.blue = blue;
        this.moves = moves;
    }
}