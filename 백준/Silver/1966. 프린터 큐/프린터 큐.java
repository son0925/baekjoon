import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        // 테스트 케이스
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            run(in);
        }
    }

    public static void run(Scanner in) {
        int N = in.nextInt();
        int target = in.nextInt();

        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int num = in.nextInt();
            queue.add(new int[] {num, i}); // 값과 원래 인덱스를 저장
            pq.add(num);
        }

        int result = 0;
        while (!queue.isEmpty()) {
            int[] curTask = queue.poll(); // 현재 작업
            int curValue = curTask[0];
            int curIndex = curTask[1];

            // 가장 높은 우선순위와 일치하면 처리
            if (curValue == pq.peek()) {
                pq.poll(); // 우선순위 큐에서 제거
                result++;
                if (curIndex == target) { // 목표 작업이면
                    System.out.println(result);
                    return;
                }
            } else {
                // 우선순위가 높지 않으면 다시 큐에 추가
                queue.add(curTask);
            }
        }
    }
}
