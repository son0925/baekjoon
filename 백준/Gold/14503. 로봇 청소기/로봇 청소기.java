import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;

    static int r;
    static int c;
    static int d;

    static int[][] room;

    final static int[] dx = {-1,0,1,0};
    final static int[] dy = {0,1,0,-1};

    static int result = 0; // 청소한 영역의 수


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        initRoom(in);

        run();
    }


    public static void run() {
        while (true) {
            if (room[r][c] == 0) {
                room[r][c] = -1;
                result++;
            }

            // 주변에 빈 칸이 존재할 때
            if (search()) {
                move();
            }
            // 빈 칸이 존재하지 않고 움직일 수 없을 때
            else if (!backAble()){
                System.out.println(result);
                return;
            }
        }
    }

    public static boolean backAble() {
        int nx = r + dx[(d+2) % 4];
        int ny = c + dy[(d+2) % 4];

        // 크기를 넘지 않고 벽이 아니면 후진 가능
        if (nx >= 0 && ny >= 0 && nx < room.length && ny < room[0].length && room[nx][ny] != 1) {
            r = nx;
            c = ny;
            return true;
        }

        return false;
    }

    public static void move() {
        for (int i = 0; i < 4; i++) {
            
            turn();
            
            int nx = r + dx[d];
            int ny = c + dy[d];

            // 칸을 벗어나지 않고 빈 방 일 때
            if (isValid(nx,ny) && room[nx][ny] == 0) {
                r = nx;
                c = ny;
                return;
            }
        }
    }

    public static void turn() {
        d = (d + 3) % 4;
    }

    public static boolean search() {
        // 주변에 0이 있는지 확인하기
        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if (isValid(nx,ny) && room[nx][ny] == 0) {
                return true;
            }
        }

        return false;
    }

    public static void print() {
        for (int[] arr : room) {
            System.out.println(Arrays.toString(arr));
        }
    }



    public static void initRoom(Scanner in) {
        N = in.nextInt();
        M = in.nextInt();

        r = in.nextInt(); // x좌표
        c = in.nextInt(); // y좌표
        d = in.nextInt(); // 방향 (0: 북, 1: 동, 2: 남, 3: 서)

        room = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                room[i][j] = in.nextInt();
            }
        }
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < room.length && y < room[0].length;
    }
}
