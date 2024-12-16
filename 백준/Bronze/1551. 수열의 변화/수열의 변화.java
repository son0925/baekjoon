import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();
        in.nextLine();

        int[] arr = Arrays.stream(in.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray()
                ;

        for (int i = 0; i < K; i++) {

            for (int j = 1; j < N; j++) {
                arr[j-1] = arr[j] - arr[j-1];
            }

            N--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(",");
        }

        sb.setLength(sb.length()-1);

        System.out.println(sb);
    }
}
