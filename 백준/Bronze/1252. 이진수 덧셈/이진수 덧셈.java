import java.util.*;
import java.io.*;


public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        StringBuilder sb1 = new StringBuilder(st.nextToken());
        StringBuilder sb2 = new StringBuilder(st.nextToken());

        sb1.reverse();
        sb2.reverse();

        int minLen = Math.min(sb1.length(), sb2.length());

        StringBuilder sb = new StringBuilder();
        int remainder = 0;
        for (int i = 0; i < minLen; i++) {
            int n = sb1.charAt(i) - '0' + sb2.charAt(i) - '0' + remainder;

            if (n >= 2) {
                remainder = 1;
                n %= 2;
            } else {
                remainder = 0;
            }

            sb.append(n);
        }

        for (int i = minLen; i < sb1.length(); i++) {
            int n = sb1.charAt(i) - '0' + remainder;

            if (n >= 2) {
                remainder = 1;
                n %= 2;
            } else {
                remainder = 0;
            }

            sb.append(n);
        }

        for (int i = minLen; i < sb2.length(); i++) {
            int n = sb2.charAt(i) - '0' + remainder;

            if (n >= 2) {
                remainder = 1;
                n %= 2;
            } else {
                remainder = 0;
            }

            sb.append(n);
        }

        if (remainder > 0) {
            sb.append(remainder);
        }

        sb.reverse();

        StringBuilder result = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < sb.length(); i++) {
            int n = sb.charAt(i) - '0';

            if (flag && n == 0) {
                continue;
            } else {
                flag = false;
            }

            result.append(n);
        }

        if (result.length() == 0) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}