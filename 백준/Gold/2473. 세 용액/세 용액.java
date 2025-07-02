import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static long[] arr;

    static long result = Long.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N-2; i++) {
            int left = i+1;
            int right = arr.length-1;

            while(left < right) {
                long sum = arr[i] + arr[left] + arr[right];
                long absSum = Math.abs(sum);

                if (absSum < result) {
                    result = absSum;
                    sb = new StringBuilder();
                    sb.append(arr[i]).append(" ").append(arr[left]).append(" ").append(arr[right]);
                }

                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.println(sb);
    }
}