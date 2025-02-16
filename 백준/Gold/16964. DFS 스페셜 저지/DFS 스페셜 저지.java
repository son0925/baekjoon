import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Set<Integer>[] graph;

    static boolean flag = false;

    static int[] input;

    static int N;
    static Stack<Integer> stk = new Stack<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        input = new int[N];
        graph = new Set[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new HashSet<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        if (input[0] != 1) {
            System.out.println(0);
            return;
        }
        
        dfs(0, 1);

        if (!flag) {
            System.out.println(0);
        }
    }

    public static void dfs(int curIdx, int targetIdx) {
        if (targetIdx == N) {
            flag = true;
            System.out.println(1);
        }
        if (flag) return;

        if (graph[input[curIdx]].contains(input[targetIdx])) {
            stk.push(curIdx);
            dfs(targetIdx, targetIdx+1);
        } else {
            if (stk.isEmpty()) return;

            dfs(stk.pop(), targetIdx);
        }
    }
}