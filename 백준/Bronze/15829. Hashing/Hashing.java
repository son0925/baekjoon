import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        long result = 0;
        String input = br.readLine();
        for (int i = 0; i < n; i++) {
            long num = input.charAt(i) - 'a' + 1;

            long mul = 1;
            for (int j = 0; j < i; j++) {
                mul = (mul * 31) % 1234567891;
            }

            result = (result + num * mul) % 1234567891;

        }

        System.out.println(result);
    }
}