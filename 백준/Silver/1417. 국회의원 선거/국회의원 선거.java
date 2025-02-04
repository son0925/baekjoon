import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        while (!pq.isEmpty()) {
            int num = pq.poll();


            if (num >= n) {
                num--;
                n++;
                result++;
            } else {
                break;
            }

            pq.offer(num);
        }

        System.out.println(result);
    }
}