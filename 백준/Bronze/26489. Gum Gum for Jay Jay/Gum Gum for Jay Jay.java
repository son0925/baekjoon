import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int result = 0;

        while(true) {
            try {
                String input = br.readLine();

                if (input.equals("gum gum for jay jay")) {
                    result ++;
                }
            } catch(Exception e) {
                break;
            }
        }

        System.out.println(result);
    }
}