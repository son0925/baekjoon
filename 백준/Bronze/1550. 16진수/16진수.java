import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String hexaDeciaml = br.readLine();

        int decimal = 0;
        for (int i = hexaDeciaml.length()-1, idx = 0; i >= 0; i--, idx++) {
            if (hexaDeciaml.charAt(i) >= '0' && hexaDeciaml.charAt(i) <= '9') {
                decimal += (hexaDeciaml.charAt(i) - '0') * Math.pow(16, idx);
            } else {
                decimal += (hexaDeciaml.charAt(i) - 55) * Math.pow(16, idx);
            }
        }

        System.out.println(decimal);

    }
}