import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        arr[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int target = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] < target && target < arr[i+1]) {
                result += counting(arr[i], arr[i+1], target);
            }
        }

        System.out.println(result);
    }

    public static int counting(int l, int r, int t) {
        int result = 0;
        for (int i = l+1; i < r-1; i++) {
            for (int j = i+1; j < r; j++) {
                if (i <= t && t <= j) {
                    result++;
                }
            }
        }

        return result;
    }
}