import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static List<List<Node>> graph = new ArrayList<>();

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(v1).add(new Node(v2, cost));
            graph.get(v2).add(new Node(v1, cost));
        }

        dijkstra();
    }

    public static void dijkstra() {
        int[] dist = new int[N+1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (dist[curNode.idx] < curNode.cost) {
                continue;
            }

            for (Node adj : graph.get(curNode.idx)) {
                if (dist[adj.idx] > curNode.cost + adj.cost) {
                    dist[adj.idx] = curNode.cost + adj.cost;
                    pq.offer(new Node(adj.idx, dist[adj.idx]));
                }
            }
        }
        System.out.println(dist[N]);
    }
}

class Node implements Comparable<Node>{
    int idx;
    int cost;

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}