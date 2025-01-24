import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 운동하는 시간
        int m = Integer.parseInt(st.nextToken()); // 초기 맥박
        int M = Integer.parseInt(st.nextToken()); // 최대 맥박
        int T = Integer.parseInt(st.nextToken()); // 운동할 때 올라가는 맥박
        int R = Integer.parseInt(st.nextToken()); // 휴식할 때 떨어지는 맥박

        if (M - m < T) {
            System.out.println(-1);
            return;
        }

        int curM = m;
        int result = 0;
        while (N > 0) {
            if (curM + T <= M) {
                curM += T;
                N--;
            } else {
                curM = Math.max(curM - R, m);
            }

            result++;
        }

        System.out.println(result);
    }
}