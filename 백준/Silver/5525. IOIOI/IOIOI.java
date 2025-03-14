import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        String input = br.readLine();
        String compare = getCompareString(N);

        int result = 0;
        for (int i = 0; i <= M - compare.length(); i++) {

            if (input.charAt(i) != 'I' || input.charAt(i + compare.length() -1) != 'I') {
                continue;
            }

            if (input.substring(i, i+compare.length()).equals(compare)) {
                result++;
            }
        }

        System.out.println(result);
    }

    public static String getCompareString(int N) {
        StringBuilder sb = new StringBuilder();
        sb.append("I");

        for (int i = 0; i < N; i++) {
            sb.append("OI");
        }

        return sb.toString();
    }
}