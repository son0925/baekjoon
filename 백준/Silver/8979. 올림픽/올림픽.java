import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i] = new int[] {num, g, s, b};
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o2[1] - o1[1];
                }

                if (o1[2] != o2[2]) {
                    return o2[2] - o1[2];
                }

                return o2[3] - o1[3];
            }
        });

        int rank = 1;
        if (arr[0][0] == M) {
            System.out.println(rank);
            return;
        }

        for (int i = 1; i < N; i++) {
            if (!(arr[i-1][1] == arr[i][1] && arr[i-1][2] == arr[i][2] && arr[i-1][3] == arr[i][3])) {
                rank = i + 1;
            }

            if (arr[i][0] == M) {
                System.out.println(rank);
                return;
            }
        }
    }
}