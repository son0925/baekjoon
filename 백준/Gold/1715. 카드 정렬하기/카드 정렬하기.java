import java.io.*;
import java.util.*;

public class Main {
    static Scanner in;

    public static void main(String[] args) throws IOException {
        in = new Scanner(System.in);

        int N = in.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.offer(in.nextLong());
        }

        long total = 0;
        while (pq.size() > 1) {
            long first = pq.poll();
            long second = pq.poll();

            total += first + second;

            pq.offer(first + second);
        }

        System.out.println(total);
    }
}