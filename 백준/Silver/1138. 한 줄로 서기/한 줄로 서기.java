import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] arr = new int[N+1];
        int[] result = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = in.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            int j = 1;

            while (true) {
                if (arr[i] == 0 && result[j] == 0) {
                    result[j] = i;
                    break;
                } else if (result[j] == 0) {
                    arr[i]--;
                }

                j++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}