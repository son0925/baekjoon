import java.util.*;

public class Main {

    static int N;
    static int M;

    static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();
        in.nextLine();

        int result = 0;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(in.nextLine(), 1);
        }


        for (int i = 0; i < M; i++) {
            result += map.getOrDefault(in.nextLine(), 0);
        }


        System.out.println(result);
    }
}