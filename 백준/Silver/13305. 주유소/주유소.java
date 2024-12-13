import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        long result = 0;

        int N = in.nextInt();
        long[] amount = new long[N];
        long[] distance = new long[N-1];

        for (int i = 0; i < N-1; i++) {
            distance[i] = in.nextInt();
        }


        for (int i = 0; i < N; i++) {
            amount[i] = in.nextInt();
        }

        long min = amount[0];

        for (int i = 0; i < N-1; i++) {
            min = Math.min(min, amount[i]);
            result += min * distance[i];
        }

        System.out.println(result);

    }
}
