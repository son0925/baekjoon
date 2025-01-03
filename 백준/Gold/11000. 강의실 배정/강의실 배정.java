import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        Class[] classes = new Class[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());

            classes[i] = new Class(start, end);
        }

        Arrays.sort(classes);

        int max = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (Class cls : classes) {
            while (!pq.isEmpty() && pq.peek() <= cls.start) {
                pq.poll();
            }

            pq.offer(cls.end);
            max = Math.max(max, pq.size());
        }

        System.out.println(max);
    }
}


class Class implements Comparable<Class> {
    long start;
    long end;

    public Class(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Class o) {
        if (this.start != o.start) {
            return Long.compare(this.start, o.start);
        }
        return Long.compare(this.end, o.end);
    }
}