import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long result = N;
        for (int i = 0; i < N; i++) {
            arr[i] -= n;
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] > 0) {
                result += arr[i] / m;

                if (arr[i] % m > 0) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}