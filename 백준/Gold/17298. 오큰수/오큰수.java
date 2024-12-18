import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] arr = new int[N];
        int[] result = new int[N];
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        for (int i = N - 1; i >= 0; i--) {
            int num = arr[i];

            while (!stk.isEmpty() && stk.peek() <= num) {
                stk.pop();
            }

            result[i] = stk.isEmpty() ? -1 : stk.peek();

            stk.push(num);
        }

        StringBuilder sb = new StringBuilder();
        for (int r : result) {
            sb.append(r).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}