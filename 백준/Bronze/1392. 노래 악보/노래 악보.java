import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        arr[0] = Integer.parseInt(br.readLine());
        for (int i = 1; i < N; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < Q; i++) {
            int time = Integer.parseInt(br.readLine());

            for (int j = 0; j < N; j++) {
                if (time < arr[j]) {
                    sb.append(j+1).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}