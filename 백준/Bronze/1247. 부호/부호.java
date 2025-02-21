import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 3; i++) {
            Main.solution();
        }
    }

    public static void solution() throws IOException {
        int N = Integer.parseInt(br.readLine());

        BigInteger result = new BigInteger(br.readLine());
        for (int i = 1; i < N; i++) {
            result = result.add(new BigInteger(br.readLine()));
        }

        String flag = "" + result.compareTo(new BigInteger("0"));

        if (flag.charAt(0) == '-' || flag.charAt(0) == '0') {
            System.out.println(flag.charAt(0));
        } else {
            System.out.println("+");
        }
    }
}