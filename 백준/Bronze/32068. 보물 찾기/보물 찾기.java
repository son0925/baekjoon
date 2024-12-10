import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        // 테스트 케이스 수
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int l = in.nextInt(); // left
            int r = in.nextInt(); // right

            int s = in.nextInt(); // 시작 위치

            if (s == l || s == r) {
                System.out.println(1);
            }

            else {
                System.out.println(Math.min((s-l) * 2 + 1, (r - s) * 2));
            }
        }
    }
}
