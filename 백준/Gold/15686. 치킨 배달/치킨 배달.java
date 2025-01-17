import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static List<Loc> homeList = new ArrayList<>();
    static List<Loc> chickenList = new ArrayList<>();
    static Stack<Loc> stk = new Stack<>();
    static boolean[] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int minCount = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());

                if (n == 1) {
                    homeList.add(new Loc(i, j, 0));
                }

                if (n == 2) {
                    chickenList.add(new Loc(i, j, 0));
                }
            }
        }

        visited = new boolean[chickenList.size()];


        dfs(0, M);


        System.out.println(minCount);
    }


    public static void dfs(int start, int count) {
        if (count == 0) {
            search();
            return;
        }

        for (int i = start; i < chickenList.size(); i++) {
            if (!visited[i]) {
                Loc loc = chickenList.get(i);
                visited[i] = true;
                stk.push(loc);

                dfs(i + 1, count - 1);

                stk.pop();
                visited[i] = false;
            }
        }
    }

    public static void search() {
        int sum = 0;

        for (Loc now : homeList) {
            sum += getDistance(now.x, now.y);
        }

        minCount = Math.min(minCount, sum);
    }

    public static int getDistance(int x, int y) {
        int minDistance = Integer.MAX_VALUE;

        for (Loc chicken : stk) {
            minDistance = Math.min(minDistance, Math.abs(chicken.x - x) + Math.abs(chicken.y - y));
        }

        return minDistance;
    }
}

class Loc {
    int x;
    int y;
    int count;

    public Loc(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}