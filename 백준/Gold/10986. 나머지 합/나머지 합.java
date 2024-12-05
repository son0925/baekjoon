import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        long[] prefixSum = new long[N];
        long[] remainderCount = new long[M];

        prefixSum[0] = arr[0] % M;
        remainderCount[(int)prefixSum[0]]++;

        for (int i = 1; i < N; i++) {
            prefixSum[i] = (prefixSum[i-1] + arr[i]) % M;
            remainderCount[(int)prefixSum[i]]++;
        }

        long result = remainderCount[0];
        for (int i = 0; i < M; i++) {
            result += remainderCount[i] * (remainderCount[i] - 1) / 2;
        }

        System.out.println(result);
    }
}
