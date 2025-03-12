import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BigInteger n1 = new BigInteger(br.readLine());
        BigInteger n2 = new BigInteger(br.readLine());

        System.out.println(n1.add(n2));
        System.out.println(n1.subtract(n2));
        System.out.println(n1.multiply(n2));
    }
}