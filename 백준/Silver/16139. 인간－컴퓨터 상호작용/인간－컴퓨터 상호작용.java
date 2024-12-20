import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        HashMap<Character, Integer>[] map = new HashMap[input.length()];

        map[0] = new HashMap<>();
        map[0].put(input.charAt(0), 1);
        for (int i = 1; i < input.length(); i++) {
            map[i] = new HashMap<>(map[i - 1]);

            char c = input.charAt(i);
            int currentCount = map[i].getOrDefault(c, 0);
            map[i].put(c, currentCount + 1);
        }

        int T = Integer.parseInt(in.nextLine());

        for (int i = 0; i < T; i++) {
            String[] tmp = in.nextLine().split(" ");

            char target = tmp[0].charAt(0);
            int left = Integer.parseInt(tmp[1]);
            int right = Integer.parseInt(tmp[2]);

            int rightCount = map[right].getOrDefault(target, 0);
            int leftCount = (left > 0) ? map[left - 1].getOrDefault(target, 0) : 0;

            System.out.println(rightCount - leftCount);
        }
    }
}