import java.io.*;
import java.util.*;

public class Main {
    static Scanner in;

    static int N; // 지역 개수
    static int M; // 수색 범위
    static int R; // 길의 개수

    static int[] items; // 각 지역 별 아이템 수
    static int[][] distances;

    static int count = 0;

    static int max = 0;

    /**
     * 1. 1번째 줄에서 지역의 개수, 수색범위, 길의 개수를 받는다.
     * 2. 2번째 줄에서 각 지역별 아이템 개수를 받는다.
     * 3. 3번째 줄에서 1,2 요소는 지역을 받고 3 요소는 길이를 받는다.
     * 3-1. 배열의 크기는 + 1로 받고 저장
     * 4. 지역간 이동 값을 받는다.
     * 5. 각 지역에서 시작했을 때 bfs 하여 아이템 최댓값을 구한다.
     * 6. 해당 시작 지점을 최댓값을 저장하기
     *
     * bfs 로직
     * 1. queue, visited 생성
     * ※ queue : 해당 회차를 저장
     * ※ visited : 해당 시작 노드에서 접근할 수 있는 모든 지역 표현 (방문 여부로 items 갯수 count)
     * 2. 해당 지역에서 다른 지역으로 이동 가능한 곳 탐색
     * 3. 이동이 가능하다면 수색 범위인지 확인하기
     * 4. 수색 범위라면 수색 범위에서 거리를 빼고 해당 노드와 거리를 큐에 저장하기
     * 5. 모든 탐색이 완료되었다면 해당 start 노드의 아이템 갯수 count 하기
     */
    public static void main(String[] args) throws IOException {
        in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();
        R = in.nextInt();

        initItems();

        initDistances();

        for (int i = 1; i <= N; i++) {
            count = 0;
            bfs(i);
            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    public static void bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start, M});
        boolean[] visited = new boolean[N+1];
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int curNode = tmp[0];
            int distance = tmp[1];

            for (int i = 1; i <= N; i++) {
                if (curNode == i) continue;

                if (distances[curNode][i] > 0) {
                    int n = distance - distances[curNode][i];

                    if (n >= 0) {
                        visited[i] = true;
                        queue.offer(new int[] {i, n});
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                count += items[i];
            }
        }
    }

    public static void print() {
        for (int[] arr : distances) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void initDistances() {
        distances = new int[N+1][N+1];

        for (int i = 0; i < R; i++) {
            int n1 = in.nextInt();
            int n2 = in.nextInt();
            int distance = in.nextInt();

            distances[n1][n2] = distance;
            distances[n2][n1] = distance;
        }
    }

    public static void initItems() {
        items = new int[N+1];

        for (int i = 1; i <= N; i++) {
            items[i] = in.nextInt();
        }
    }
}