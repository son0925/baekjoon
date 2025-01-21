import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int l = 1;
        int r = K;

        while (l < r) {
            int mid = (l + r) / 2;

            int count = 0;
            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            if (count >= K) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
    }
}