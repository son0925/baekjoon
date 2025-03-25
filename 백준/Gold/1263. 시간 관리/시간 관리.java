import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        Work[] works = new Work[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            works[i] = new Work(endTime - time, endTime);
        }

        Arrays.sort(works);

        Work cur = works[0];
        for (int i = 1; i < N; i++) {
            Work compare = works[i];

            if (cur.s < compare.e) {
                int diff = compare.e - cur.s;

                compare.diff(diff);
            }

            cur = compare;
        }

        if (cur.s < 0) {
            System.out.println(-1);
        } else {
            System.out.println(cur.s);
        }
    }
}

class Work implements Comparable<Work>{
    int s;
    int e;

    public Work(int s, int e) {
        this.s = s;
        this.e = e;
    }

    public void diff(int diff) {
        this.s -= diff;
        this.e -= diff;
    }

    @Override
    public int compareTo(Work o) {
        if (this.e != o.e) {
            return o.e - this.e;
        }
        return o.s - this.s;
    }

    @Override
    public String toString() {
        return s + " " + e;
    }
}