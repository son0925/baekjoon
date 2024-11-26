import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        double[] arr = new double[9];

        while (num > 0) {
            int n = num % 10;

            if (n == 9) {
                n = 6;
            }
            num /= 10;
            arr[n]++;
        }
        arr[6] /= 2;

        double max = -1;
        for (int i = 0; i < 9; i++) {
            max = Math.max(max, arr[i]);
        }

        System.out.println((int) Math.ceil(max));
    }
}
