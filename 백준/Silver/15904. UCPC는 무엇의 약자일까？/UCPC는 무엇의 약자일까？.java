import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        String UCPC = "UCPC";
        String ucpc = "ucpc";

        int upperIdx = 0;
        int lowerIdx = 0;

        String result = "hate";
        for (char c : input.toCharArray()) {
            if (UCPC.charAt(upperIdx) == c) {
                upperIdx++;
            } else if (ucpc.charAt(lowerIdx) == c) {
                lowerIdx++;
            }

            if (upperIdx == 4 || lowerIdx == 4) {
                result = "love";
                break;
            }
        }

        System.out.printf("I %s UCPC", result);
    }
}