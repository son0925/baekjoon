import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        for (int i = 0; i < n; i++) {
            String command = in.nextLine();

            int size = Integer.parseInt(in.nextLine());

            String input = in.nextLine();
            input = input.substring(1, input.length() - 1);

            Deque<String> deque = new ArrayDeque<>();
            if (size > 0) {
                String[] elements = input.split(",");
                Collections.addAll(deque, elements);
            }

            boolean reverseFlag = false;
            boolean isError = false;

            for (char cmd : command.toCharArray()) {
                if (cmd == 'R') {
                    reverseFlag = !reverseFlag;
                } else if (cmd == 'D') {
                    if (deque.isEmpty()) {
                        System.out.println("error");
                        isError = true;
                        break;
                    }
                    if (reverseFlag) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            if (!isError) {
                printDeque(deque, reverseFlag);
            }
        }
    }

    public static void printDeque(Deque<String> deque, boolean reverseFlag) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if (reverseFlag) {
            Iterator<String> it = deque.descendingIterator();
            while (it.hasNext()) {
                sb.append(it.next()).append(",");
            }
        } else {
            Iterator<String> it = deque.iterator();
            while (it.hasNext()) {
                sb.append(it.next()).append(",");
            }
        }

        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1); 
        }
        sb.append("]");

        System.out.println(sb.toString());
    }
}