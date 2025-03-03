import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        if (input.length() <= 1) {
            System.out.println("NO");
            return;
        }

        for (int i = 1; i < input.length(); i++) {
            String o1 = input.substring(0, i);
            String o2 = input.substring(i, input.length());

            if (isYooJinSoo(o1, o2)) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");

    }

    public static boolean isYooJinSoo(String o1, String o2) {
        return digitMultiplication(o1) == digitMultiplication(o2);
    }


    public static long digitMultiplication(String num) {
        long result = 1;

        for (int i = 0; i < num.length(); i++) {
            result *= num.charAt(i) - '0';
        }

        return result;
    }
}