import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        while (true) {
            String number = br.readLine();
            int len = number.length() + 1;

            if (number.equals("0")) {
                break;
            }

            for (char c : number.toCharArray()) {
                if (c == '1') {
                    len += 2;
                } else if (c == '0') {
                    len += 4;
                } else {
                    len += 3;
                }
            }

            sb.append(len).append("\n");
        }

        System.out.println(sb);
    }
}