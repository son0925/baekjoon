import java.io.*;
import java.util.*;

public class Main {

    static String input;
    static final Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        input = in.nextLine();

        for (int i = 1; i <= input.length(); i++) {
            combination(i);
        }

        System.out.println(set.size());
    }

    public static void combination(int count) {
        for (int i = 0; i <= input.length() - count; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i+count; j++) {
                sb.append(input.charAt(j));
            }

            set.add(sb.toString());
        }
    }
}
