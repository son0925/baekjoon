import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] visited;
    static int[] result = {0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        bfs();

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }


    public static void bfs() {
        Queue<Loc> queue = new LinkedList<>();
        queue.offer(new Loc(N, 0));

        while(!queue.isEmpty()) {
            Loc cur = queue.poll();

            if (cur.index == M) {
                if (result[1] == 0) {
                    result[0] = cur.count;
                }

                if (result[0] == cur.count) {
                    result[1]++;
                }

                continue;
            }

            int[] dx = {cur.index + 1, cur.index -1, cur.index * 2};
            for (int i = 0; i < dx.length; i++) {
                int nx = dx[i];

                if (isRange(nx) && visited[nx] >= cur.count+1) {
                    visited[nx] = cur.count+1;
                    queue.offer(new Loc(nx, cur.count+1));
                }
            }
        }
    }

    public static boolean isRange(int x) {
        return x >= 0 && x <= 100000;
    }
}

class Loc {
    int index;
    int count;

    public Loc(int index, int count) {
        this.index = index;
        this.count = count;
    }
}