import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            for (int j = 1; j < N; j++) {
                arr[i][j] = arr[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            int result = 0;

            for (int j = x1; j <= x2; j++) {
                result += arr[j][y2];
                if (y1 - 1 >= 0) {
                    result -= arr[j][y1 - 1];
                }
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
