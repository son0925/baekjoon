import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        while (input != null) {
            int n = (int) Math.pow(3, Integer.parseInt(input));

            for (int i = 0; i < n; i++) {
                sb.append("-");
            }

            recursion(0, n);

            System.out.println(sb.toString().trim());
            sb = new StringBuilder();

            input = br.readLine();
        }

    }


    public static void recursion(int start, int end) {
        if (end - start <= 1) {
            return;
        }

        int n = start + end;

        int m = start + (end - start) / 3;
        int e = start + (end - start) / 3 * 2;

        for (int i = m; i < e; i++) {
            sb.setCharAt(i, ' ');
        }

        recursion(start, m);
        recursion(e, end);
    }
}