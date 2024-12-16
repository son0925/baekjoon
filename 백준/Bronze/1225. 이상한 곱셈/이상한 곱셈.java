import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        String n = in.next();
        String m = in.next();

        long result = 0;

        for (char c1 : n.toCharArray()) {
            for (char c2 : m.toCharArray()) {
                result += (long)(c1 - '0') * (c2 - '0');
            }
        }

        System.out.println(result);
    }
}
