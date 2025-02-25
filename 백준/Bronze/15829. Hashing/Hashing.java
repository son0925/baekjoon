import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        String input = br.readLine();
        for (int i = 0; i < n; i++) {
            result = (int) ((result + (input.charAt(i) - 'a' + 1) * Math.pow(31, i)) % 1234567891);
        }

        System.out.println(result);
    }
}