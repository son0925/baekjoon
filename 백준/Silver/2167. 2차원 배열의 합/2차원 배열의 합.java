import java.util.*;
import java.io.*;

public class Main {

    static Scanner in;

    public static void main(String[] args) throws IOException {
        in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        int[][] arr = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                arr[i][j] = in.nextInt()
                        + arr[i][j-1]
                        + arr[i-1][j]
                        - arr[i-1][j-1]
                        ;
            }
        }


        int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();

            int x2 = in.nextInt();
            int y2 = in.nextInt();

            int result = arr[x2][y2]
                    - arr[x1-1][y2]
                    - arr[x2][y1-1]
                    + arr[x1-1][y1-1]
                    ;

            System.out.println(result);
        }
    }
}
