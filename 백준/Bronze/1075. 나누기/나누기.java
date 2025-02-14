import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine()) / 100 * 100;
        int F = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i <= 100; i++) {
            if ((N + i) % F == 0) {
                result = i;
                break;
            }
        }

        if (result < 10) {
            System.out.println("0" + result);
        } else {
            System.out.println(result);
        }
    }
}