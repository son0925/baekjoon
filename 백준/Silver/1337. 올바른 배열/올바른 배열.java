import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int result = 4;
        for (int i = 0; i < N-1; i++) {
            int n = arr[i];
            int cnt = 4;
            for (int j = i+1; j < i+5 && j < N; j++) {
                if (n + 4 >= arr[j]) {
                    cnt--;
                }
            }

            result = Math.min(result, cnt);
        }

        System.out.println(result);
    }
}