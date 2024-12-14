import java.util.*;
import java.io.*;

public class Main {

    static String[][] graph;
    static int N;
    static int max = -1;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        in.nextLine();

        graph = new String[N][N];
        for (int i = 0; i < N; i++) {
            graph[i] = in.nextLine().split("");
        }


        for (int i = 0; i < N; i++) {
            max = Math.max(max, bfs(i));
        }

        System.out.println(max);
    }

    public static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();

        // idx, depth
        queue.add(new int[] {start, 0});

        // 방문 여부
        boolean[] visit = new boolean[N];
        visit[start] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int idx = tmp[0];
            int depth = tmp[1];

            // 이미 각 사람의 2-친구라면
            if (depth >= 2) {
                continue;
            }

            for (int i = 0; i < N; i++) {
                if (graph[idx][i].equals("Y") && !visit[i]) {
                    count++;
                    visit[i] = true;
                    queue.add(new int[] {i, depth + 1});
                }
            }
        }
        return count;
    }
}
