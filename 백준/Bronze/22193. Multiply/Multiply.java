import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int M;

    static Integer[][] dp;

    static final int max = 100_000_000;

    public static void main(String[] args) throws IOException {
        br.readLine();

        BigInteger n1 = new BigInteger(br.readLine());
        BigInteger n2 = new BigInteger(br.readLine());

        System.out.println(n1.multiply(n2));

    }
}