import java.io.*;
import java.util.*;

public class Main {

    static int result = -1;
    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = in.nextInt();
        M = in.nextInt();

        arr = new int[N];

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i] = in.nextInt();
        }

        long start = 1;
        long end = sum / M;

        search(start, end);

        System.out.println(result);
    }

    public static void search(long start, long end) {
        while (start <= end) {
            long mid = (start + end) / 2;

            if (mid == 0) return;

            long count = 0;
            for (int i = 0; i < N; i++) {
                count += arr[i] / mid;
            }

            if (count >= M) {
                result = Math.max(result, (int) mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
}