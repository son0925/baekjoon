import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Puddle[] puddles = new Puddle[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            puddles[i] = new Puddle(s, e);
        }

        Arrays.sort(puddles);



        int result = 0;
        Puddle p = puddles[0];
        int s = p.s;
        int e = p.e;

        // 거리
        int d = e - s;
        // 작업량
        int work = d / L;
        if (d % L > 0) {
            work++;
        }

        result += work;
        int lastS = s  + work * L;

        for (int i = 1; i < N; i++) {
            Puddle cur = puddles[i];

            s = Math.max(cur.s, lastS);
            e = cur.e;

            if (s >= e) {
                continue;
            }

            d = e - s;
            work = d / L;
            if (d % L > 0) {
                work++;
            }

            result += work;
            lastS = s + work * L;

        }

        System.out.println(result);
    }
}

class Puddle implements Comparable<Puddle> {
    int s;
    int e;

    public Puddle(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Puddle other) {
        if (this.s != other.s) {
            return Integer.compare(this.s, other.s);
        }

        return Integer.compare(this.e, other.e);
    }

    @Override
    public String toString() {
        return s + " " + e;
    }


}