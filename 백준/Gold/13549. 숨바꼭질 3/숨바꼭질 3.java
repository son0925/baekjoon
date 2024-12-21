import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int result = Integer.MAX_VALUE;
    static int[] move = {-1, 1};

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();

        bfs();
        System.out.println(result);
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0));

        int maxSize = Math.max(N, M) * 2 + 1;
        int[] visited = new int[maxSize];
        Arrays.fill(visited, Integer.MAX_VALUE);

        visited[N] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int curIdx = curNode.index;
            int curCount = curNode.count;

            if (curIdx == M) {
                result = Math.min(result, curCount);
                continue;
            }

            for (int i = 0; i < 2; i++) {
                int newIdx = curIdx + move[i];
                int newCount = curCount + 1;

                if (newIdx >= 0 && newIdx < maxSize && visited[newIdx] > newCount) {
                    visited[newIdx] = newCount;
                    queue.add(new Node(newIdx, newCount));
                }
            }

            int newIdx = curIdx * 2;
            if (newIdx >= 0 && newIdx < maxSize && visited[newIdx] > curCount) {
                visited[newIdx] = curCount;
                queue.add(new Node(newIdx, curCount));
            }
        }
    }
}

class Node {
    int index;
    int count;

    Node(int index, int count) {
        this.index = index;
        this.count = count;
    }
}