import java.util.*;
import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        System.out.println(Rev(Rev(x) + Rev(y)));
    }

    public static int Rev(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);

        return Integer.parseInt(sb.reverse().toString());
    }
}