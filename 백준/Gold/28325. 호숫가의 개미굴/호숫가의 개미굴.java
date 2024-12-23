import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static final Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();

        long result = 0;

        long[] arr = new long[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextLong();
        }

        Arrays.sort(arr);

        int i = 0;
        if (arr[0] == 0) {
            i = 1;
        }

        for (; i < arr.length; i++) {
            long count = arr[i];

            if (arr[i] < 1) {
                count = 1;
            }

            result += count;
        }

        System.out.println(result);
    }
}
