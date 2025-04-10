import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        arr = new boolean[5][5];
        Map<Integer,Loc> map = new HashMap<>();

        int count = 0;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                int n = Integer.parseInt(st.nextToken());

                map.put(n, new Loc(i, j));
            }
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                count++;
                int n = Integer.parseInt(st.nextToken());

                Loc location = map.get(n);
                arr[location.x][location.y] = true;

                if (count > 11 && isBingo()) {
                    System.out.println(count);
                    return;
                }
            }
        }
    }

    public static boolean isBingo() {
        int count = 0;

        for (int i = 0; i < 5; i++) {
            if (arr[i][0] && arr[i][1] && arr[i][2] && arr[i][3] && arr[i][4]) {
                count++;
            }

            if (arr[0][i] && arr[1][i] && arr[2][i] && arr[3][i] && arr[4][i]) {
                count++;
            }
        }

        if (arr[0][0] && arr[1][1] && arr[2][2] && arr[3][3] && arr[4][4]) {
            count++;
        }

        if (arr[0][4] && arr[1][3] && arr[2][2] && arr[3][1] && arr[4][0]) {
            count++;
        }

        return count >= 3;
    }

    public static int lineCounter(int x, int y, int nx, int ny, int depth) {
        if (depth == 5) {
            return 1;
        }

        if (arr[x][y]) {
            return lineCounter(x + nx, y + ny, nx, ny, depth + 1);
        }

        return 0;
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < 5 && y < 5;
    }
}

class Loc {
    int x;
    int y;

    public Loc(int x, int y) {
        this.x = x;
        this.y = y;
    }
}