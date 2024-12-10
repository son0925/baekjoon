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

            int step = 1;
            // step 홀수 일 때 오른쪽으로 이동
            // 짝수 일 때 왼쪽으로 이동

            while (s != l && s != r) {
                if (step % 2 == 0) {
                    s -= step;
                } else {
                    s += step;
                }
                step++;
            }

            System.out.println(step);
        }
    }
}
