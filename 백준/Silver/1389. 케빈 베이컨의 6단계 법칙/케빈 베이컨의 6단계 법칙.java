import java.util.*;
import java.io.*;

public class Main {

    static boolean[][] graph;
    static int N;
    static int M;
    static int min = Integer.MAX_VALUE;
    static int cabinBacon = -1;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();

        graph = new boolean[N+1][N+1];

        for (int i = 0; i < M; i++) {
            int p1 = in.nextInt();
            int p2 = in.nextInt();

            graph[p1][p2] = true;
            graph[p2][p1] = true;
        }


        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        System.out.println(cabinBacon);
    }


    public static void bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 1}); // 위치, 횟수, 몇 회차

        int[] visit = new int[N+1];
        Arrays.fill(visit, Integer.MAX_VALUE);
        visit[start] = 0;


        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int idx = tmp[0];
            int order = tmp[1];


            for (int i = 1; i <= N; i++) {
                if (graph[idx][i] && visit[i] > order) {
                    queue.add(new int[] {i, order+1});
                    visit[i] = order;
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            result += visit[i];
        }
        if (min > result) {
            min = result;
            cabinBacon = start;
        }
    }
}
