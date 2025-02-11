import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[][] graph;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int N;
    static int M;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
    }

    public static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, graph[0][0]));
        int[][] visited = new int[N][M];
        visited[0][0] = 1;

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            int x = node.x;
            int y = node.y;
            int cost = node.cost;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!isRange(nx,ny)) continue;
                if (cost <= graph[nx][ny]) continue;

                if (visited[nx][ny] == 0) {
                    pq.offer(new Node(nx, ny, graph[nx][ny]));
                }

                visited[nx][ny] += visited[x][y];
            }
        }
        System.out.println(visited[N-1][M-1]);
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int cost;

    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return o.cost - this.cost;
    }
}