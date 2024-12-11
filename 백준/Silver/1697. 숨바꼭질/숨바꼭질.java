import java.util.*;
import java.io.*;

public class Main {

    static int target;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int curIdx = in.nextInt();
        target = in.nextInt();

        if (curIdx >= target) {
            System.out.println(curIdx - target);
            return;
        }

        System.out.println(bfs(curIdx));
    }

    public static int bfs(int idx) {
        Queue<int[]> q = new LinkedList<>();
        int[] move = {2, -1, 1};
        boolean[] visit = new boolean[100001];

        q.add(new int[] {idx, 0});
        visit[idx] = true; // 시작점 방문 처리

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int curIdx = tmp[0];
            int count = tmp[1];

            for (int i = 0; i < 3; i++) {
                int nextIdx = (i == 0) ? curIdx * 2 : curIdx + move[i];

                if (nextIdx == target) {
                    return count + 1;
                }

                if (nextIdx < 0 || nextIdx > 100_000 || visit[nextIdx]) continue;

                visit[nextIdx] = true; // 방문 처리
                q.add(new int[] {nextIdx, count + 1});
            }
        }

        return -1;
    }
}
