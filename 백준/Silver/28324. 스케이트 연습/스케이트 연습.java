import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static final Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        long result = 1;
        long lastSpeed = 1;
        for (int i = N-2; i >= 0; i--) {
            if (lastSpeed < arr[i]) {
                result += lastSpeed+1;
                lastSpeed++;
            } else {
                result += arr[i];
                lastSpeed = arr[i];
            }
        }

        System.out.println(result);
    }
}