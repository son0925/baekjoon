import java.util.*;
import java.io.*;

public class Main {

    public static long c;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        long a = in.nextInt();
        long b = in.nextInt();
        c = in.nextInt();


        System.out.println(pow(a,b));
    }

    public static long pow(long a, long b) {

        if (b == 1) {
            return a % c;
        }
        long tmp = pow(a, b / 2);

        if (b % 2 == 1) {
            return (tmp * tmp % c) * a % c;
        }

        return tmp * tmp % c;
    }
}
