import java.util.*;
import java.io.*;

public class Main {

    static Scanner in;

    public static void main(String[] args) throws IOException {
        in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        int[] arr = new int[N];
        arr[0] = in.nextInt();
        for (int i = 1; i < N; i++) {
            arr[i] = arr[i-1] + in.nextInt();
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int num = i == j ? arr[j] : arr[j] - arr[i];

                if (num == M) result ++;

            }
        }


        System.out.println(result);
    }
}
