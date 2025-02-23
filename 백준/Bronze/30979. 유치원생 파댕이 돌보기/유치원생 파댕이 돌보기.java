import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int time = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            time -= Integer.parseInt(st.nextToken());   
        }

        if (time <= 0) {
            System.out.println("Padaeng_i Happy");
        } else {
            System.out.println("Padaeng_i Cry");
        }
    }
}