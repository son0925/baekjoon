import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visited;
    static int[][] graph;
    static List<List<Integer>> groupList = new ArrayList<>();
    static List<Integer> representativeList = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        graph = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                groupList.add(bfs(i));
            }
        }
        for (List<Integer> group : groupList) {
            representativeList.add(getRepresentative(group));
        }

        Collections.sort(representativeList);
        sb.append(representativeList.size()).append("\n");
        for (int representative : representativeList) {
            sb.append(representative).append("\n");
        }

        System.out.println(sb);
    }

    public static int getRepresentative(List<Integer> group) {
        int min = Integer.MAX_VALUE;
        int representative = 0;

        // 해당 리스트를 가지고 반복문을 돌림
        // 이 때 2개 이하이면 바로 0 리턴하기
        if (group.size() <= 2) {
            return group.get(0);
        }

        // 0번째 요소를 시작으로 마지막 요소까지 모든 경로 최댓값을 구함
        for (int start : group) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] {start, 0}); // 현재 노드, count

            // 방문 기록 확인
            boolean[] visited = new boolean[N+1];
            visited[start] = true;

            // start 노드가 최댓값으로 방문하는 노드
            // 모든 노드를 방문했을 때 특정 노드까지 간 최댓값이 최솟값인 노드가 대표가 되어야함
            int max = 0;

            while(!queue.isEmpty()) {
                int[] tmp = queue.poll();

                int curNode = tmp[0];
                int count = tmp[1];

                // 현재 노드까지 count 비교
                max = Math.max(max, count);

                // 다음 노드 확인하기
                for (int next : group) {
                    // 방문하지 않았다면 queue에 삽입
                    if (!visited[next] && graph[curNode][next] > 0) {
                        visited[next] = true;
                        queue.offer(new int[] {next, count+1});
                    }
                }
            }

            // start 노드에서 연결된 모든 노드를 방문한 후 현재 최솟값과 자신의 최댓값을 비교하기
            if (max < min) {
                min = max;
                representative = start;
            }
        }

        return representative;
    }

    public static ArrayList<Integer> bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;
        ArrayList<Integer> result = new ArrayList<>();
        result.add(node);

        while(!queue.isEmpty()) {
            int nextNode = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && graph[i][nextNode] > 0) {
                    visited[i] = true;
                    result.add(i);
                    queue.offer(i);
                }
            }
        }

        return result;
    }
}