import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] parent;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        String[] genderArr = new String[V+1];
        genderArr[0] = "";
        for (int i = 1; i <= V; i++) {
            genderArr[i] = st.nextToken();
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(v1, v2, weight));
        }

        int result = 0;
        boolean[] visited = new boolean[V+1];
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (genderArr[cur.v1].equals(genderArr[cur.v2])) {
                continue;
            }

            if (find(cur.v1) != find(cur.v2)) {
                union(cur.v1, cur.v2);
                visited[cur.v1] = true;
                visited[cur.v2] = true;
                result += cur.weight;
            }
        }

        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(result);
    }

    public static void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);

        if (p1 > p2) {
            parent[p1] = p2;
        } else {
            parent[p2] = p1;
        }
    }

    public static int find(int v) {
        if (v == parent[v]) {
            return v;
        }

        return parent[v] = find(parent[v]);
    }
}

class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int weight;

    public Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}