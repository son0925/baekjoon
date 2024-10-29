import java.util.*;

public class Main {

    static int N;
    static int M;

    static int[][] map;

    static final int[] dx = {1,-1,0,0};
    static final int[] dy = {0,0,1,-1};

    static Scanner in;

    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) {
        in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();

        initMap();

        int result = bfs();

        System.out.println(allRipenTomatoes() ? result : -1);
    }

    public static int bfs() {
        int days = -1;


        while (!q.isEmpty()) {
            int size = q.size();
            days++;

            for (int i = 0; i < size; i++) {
                int[] tmp = q.poll();

                int x = tmp[0];
                int y = tmp[1];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < M && ny < N && map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }

        return days;
    }

    public static boolean allRipenTomatoes() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) return false;
            }
        }

        return true;
    }


    public static void initMap() {
        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = in.nextInt();

                if (map[i][j] == 1) {
                    q.add(new int[]{i,j});
                }
            }
        }
    }

    public static void viewMap() {
        for (int[] arr : map) {
            System.out.println(Arrays.toString(arr));
        }
    }
}