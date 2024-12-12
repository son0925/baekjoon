import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);


        int N = in.nextInt();

        int[] arr = new int[N];

        long sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
            sum += arr[i];
        }

        long result = 0;
        for (int num : arr) {
            sum -= num;
            result = (num * sum + result) % 1000000007;
        }

        System.out.println(result);
    }
}
