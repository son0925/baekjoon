import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int V;
    static int E;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V];
        for (int i = 1; i < V; i++) {
            parent[i] = i;
        }

        int result = 0;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            if (!union(v1, v2)) {
                result = i + 1;
                break;
            }
        }

        System.out.println(result);
    }

    public static boolean union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);

        if (p1 == p2) return false;

        if (p1 < p2) parent[p2] = p1;
        else parent[p1] = p2;
        return true;
    }

    public static int find(int v) {
        if (v == parent[v]) {
            return v;
        }

        return parent[v] = find(parent[v]);
    }
}