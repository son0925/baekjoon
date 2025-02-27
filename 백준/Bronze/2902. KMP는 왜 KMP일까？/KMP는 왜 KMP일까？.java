import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split("-");

        for (int i = 0; i < input.length; i++) {
            sb.append(input[i].charAt(0));
        }

        System.out.println(sb);
    }
}