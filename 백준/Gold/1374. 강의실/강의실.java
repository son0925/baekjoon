import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        Time[] arr = new Time[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[i] = new Time(n, s, e);
        }
        Arrays.sort(arr);

        int max = 0;

        for (int i = 0; i < N; i++) {
            while(!pq.isEmpty() && pq.peek() <= arr[i].start) {
                pq.poll();
            }

            pq.offer(arr[i].end);
            max = Math.max(max, pq.size());
        }

        System.out.println(max);
    }
}

class Time implements Comparable<Time>{
    int num, start, end;

    public Time(int n, int s, int e) {
        this.num = n;
        this.start = s;
        this.end = e;
    }

    @Override
    public int compareTo(Time o) {
        if (this.start != o.start) {
            return this.start - o.start;
        }

        return this.end - o.end;
    }
}