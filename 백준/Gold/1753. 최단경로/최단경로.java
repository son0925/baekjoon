import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();

        int start = in.nextInt();

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            graph.get(a).add(new Node(b, c));
        }

        int[] costArr = dijkstra(graph, start);

        for (int i = 1; i <= N; i++) {
            if (costArr[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(costArr[i]);
            }
        }
    }

    public static int[] dijkstra(List<List<Node>> graph, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] costArr = new int[N+1];
        Arrays.fill(costArr, Integer.MAX_VALUE);
        costArr[start] = 0;

        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            int curIdx = curNode.idx;
            int curCost = curNode.cost;

            if (curCost > costArr[curIdx]) continue;

            for (Node neighbor : graph.get(curIdx)) {
                int newCost = costArr[curIdx] + neighbor.cost;

                if (newCost < costArr[neighbor.idx]) {
                    costArr[neighbor.idx] = newCost;
                    pq.offer(new Node(neighbor.idx, newCost));
                }
            }
        }

        return costArr;
    }
}

class Node implements Comparable<Node> {
    int idx;
    int cost;

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.cost, other.cost);
    }
}