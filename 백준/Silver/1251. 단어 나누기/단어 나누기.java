import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String s = br.readLine();

        List<String> list = new ArrayList<>();
        for (int i = 1; i < s.length()-1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                sb = new StringBuilder(s.substring(0, i));
                String s1 = sb.reverse().toString();

                sb = new StringBuilder(s.substring(i, j));
                String s2 = sb.reverse().toString();

                sb = new StringBuilder(s.substring(j, s.length()));
                String s3 = sb.reverse().toString();

                list.add(s1 + s2 + s3);
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));
    }
}