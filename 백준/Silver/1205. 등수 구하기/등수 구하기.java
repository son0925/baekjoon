import java.util.*;
import java.io.*;

/*

자료구조 : PriorityQueue

아이디어
1. 현재까지 저장된 점수 리스트의 갯수, 자신의 점수, 랭킹에 들어갈 수 있는 커트라인 값 받기
2. 우선순위 큐에 N개 요소 넣기(이때 내림차순으로 정렬하기)
3. 우선순위 큐에서 요소 하나씩 추출하기
4. 추출한 요소의 랭킹을 정의하기
4-1 랭킹을 정의하기 위해서는 전의 숫자와 같다면 똑같은 랭킹
4-2 다르다면 rank 를 idx 로 똑같이 설정하기
5. 이렇게 요소를 랭킹 매기면서 자신의 스코어보다 작을 때 까지 확인하기
6. 작다면 랭킹 부여하고 종료하기
7. 종료했을 때 idx 가 P 보다 작거나 같은지 확인하기

 */

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // 내림차순
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        if (N == 0) {
            System.out.println(1);
            return;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }
        pq.offer(newScore);

        int lastScore = 2_000_000_001;

        int idx = 0; // 현재 idx
        int rank = 0; // 현재 rank
        while (!pq.isEmpty()) {
            int score = pq.poll();
            if (newScore > score) {
                break;
            }

            idx++;
            if (lastScore > score) {
                lastScore = score;
                rank = idx;
            }
        }

        if (idx <= P) {
            System.out.println(rank);
        } else {
            System.out.println(-1);
        }
    }
}