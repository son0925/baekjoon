import java.util.*;

public class Main {

    private static final int[] dx = {1,-1,0,0};
    private static final int[] dy = {0,0,1,-1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 테스트 케이스 갯수
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            testCase(in);
        }
    }


    public static void testCase(Scanner in) {
        // 가로 길이, 세로 길이, 배추 갯수
        int m = in.nextInt();
        int n = in.nextInt();
        int k = in.nextInt();

        int[][] graph = new int[m][n];
        for (int i = 0; i < k; i++) {
            int p1 = in.nextInt();
            int p2 = in.nextInt();

            graph[p1][p2] = 1;
        }

        int result = 0;
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && graph[i][j] == 1) {
                    result++;
                    bfs(graph, visit, i, j);
                }
            }
        }


        System.out.println(result);
    }


    public static void bfs(int[][] graph, boolean[][] visit, int x, int y) {
        visit[x][y] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < graph.length && ny < graph[0].length &&
                        !visit[nx][ny] && graph[nx][ny] == 1) {
                    queue.add(new int[] {nx,ny});
                    visit[nx][ny] = true;
                }
            }
        }
    }
}
