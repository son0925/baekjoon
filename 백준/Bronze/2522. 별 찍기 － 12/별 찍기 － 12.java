import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n * 2; i++) {
            for (int j = 0; j < n; j++) {
                if (i < n) {
                    if (i + j >= n-1) {
                        sb.append("*");
                    } else {
                        sb.append(" ");
                    }
                } else {
                    if (i - n < j) {
                        sb.append("*");
                    } else {
                        sb.append(" ");
                    }
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}