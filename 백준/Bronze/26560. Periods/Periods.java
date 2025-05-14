import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            sb.append(s);
            if (s.charAt(s.length()-1) != '.') {
                sb.append(".");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}