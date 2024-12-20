import java.io.*;
import java.util.*;

public class Main {

    static int result = 0;
    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = in.nextInt();
        M = in.nextInt();

        arr = new int[N];

        long start = 1;
        long end = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
            end = Math.max(arr[i], end);
        }

        search(start, end);
        System.out.println(result);
    }

    public static void search(long start, long end) {
        while (start <= end) {
            long mid = (start + end) / 2;

            if (mid == 0) return;


            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum += Math.max(arr[i] - mid, 0);
            }

            if (sum >= M) {
                result = (int) mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
}