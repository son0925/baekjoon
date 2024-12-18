import java.util.*;
import java.io.*;

public class Main {

    static Scanner in;

    public static void main(String[] args) throws IOException {
        in = new Scanner(System.in);

        Stack<Character> stk = new Stack<>();

        String input = in.nextLine();
        String bomb = in.nextLine();

        for (char c : input.toCharArray()) {
            stk.add(c);

            if (stk.size() >=  bomb.length()) {
                hasBomb(stk, bomb);
            }
        }

        if (stk.isEmpty()) {
            System.out.println("FRULA");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stk) {
            sb.append(c);
        }

        System.out.println(sb);
    }

    public static void hasBomb(Stack<Character> stk, String bomb) {
        int count = 0;

        for (int i = 0; i < bomb.length(); i++) {
            if (stk.get(stk.size() - bomb.length() + i) == bomb.charAt(i)) {
                count++;
            }

            if (count == bomb.length()) {
                clear(stk, bomb);
            }
        }
    }

    public static void clear(Stack<Character> stk, String bomb) {
        for (int i = 0; i < bomb.length(); i++) {
            stk.pop();
        }
    }
}
