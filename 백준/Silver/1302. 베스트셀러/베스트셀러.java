import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 책 제목과 판매 횟수를 저장할 HashMap
        Map<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(in.nextLine());

        // 입력받아 HashMap에 저장
        for (int i = 0; i < N; i++) {
            String book = in.nextLine();
            map.put(book, map.getOrDefault(book, 0) + 1);
        }

        // 우선순위 큐 생성: 판매량이 많을수록 우선, 판매량이 같으면 사전순
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (!Objects.equals(b.getValue(), a.getValue())) {
                        return b.getValue() - a.getValue(); // 판매량 내림차순
                    }
                    return a.getKey().compareTo(b.getKey()); // 사전순 오름차순
                }
        );

        // HashMap의 엔트리를 우선순위 큐에 삽입
        pq.addAll(map.entrySet());

        // 우선순위 큐에서 가장 높은 우선순위 항목 출력
        Map.Entry<String, Integer> topBook = pq.poll();
        System.out.println(topBook.getKey());
    }
}
