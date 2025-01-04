import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static String result = "";

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        recursion(new StringBuilder(), 0);

        System.out.println(result);
    }

    public static void recursion(StringBuilder sb, int lastNum) {
        if (!result.isEmpty()) {
            return;
        }

        if (sb.length() == N) {
            result = sb.toString();
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (lastNum == i) continue;

            sb.append(i);
            if (sb.length() > 1 && hasRepeatingSubsequence(sb.toString())) {
                sb.setLength(sb.length()-1);
                continue;
            }

            recursion(sb, i);
            sb.setLength(sb.length()-1);

        }
    }

    public static boolean hasRepeatingSubsequence(String sequence) {
        int n = sequence.length();

        for (int len = 1; len <= n / 2; len++) {
            for (int i = 0; i + 2 * len <= n; i++) {
                String part1 = sequence.substring(i, i + len);
                String part2 = sequence.substring(i + len, i + 2 * len);

                if (part1.equals(part2)) {
                    return true;
                }
            }
        }

        return false;
    }
}