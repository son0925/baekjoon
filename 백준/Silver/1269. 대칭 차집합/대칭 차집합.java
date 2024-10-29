import java.util.*;

public class Main {

    static int N;
    static int M;

    static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();

        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();

        HashSet<Integer> s3 = new HashSet<>();
        HashSet<Integer> s4 = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int num = in.nextInt();
            s1.add(num);
            s3.add(num);
        }

        for (int j = 0; j < M; j++) {
            int num = in.nextInt();
            s2.add(num);
            s4.add(num);
        }

        s1.removeAll(s2);
        s4.removeAll(s3);
        System.out.println(s1.size() + s4.size());
    }
}