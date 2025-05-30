import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] parents;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parents = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.offer(new Node(v1, v2, cost));
        }


        int result = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if (find(cur.v1) != find(cur.v2)) {
                union(cur.v1, cur.v2);
                result += cur.cost;
            }
        }

        System.out.println(result);
    }

    static int find(int v) {
        if (v == parents[v]) {
            return v;
        }

        return parents[v] = find(parents[v]);
    }

    static void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);

        if (p1 < p2) {
            parents[p2] = p1;
        } else {
            parents[p1] = p2;
        }
    }
}

class Node implements Comparable<Node> {
    int v1;
    int v2;
    int cost;

    public Node(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}