import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x1 = in.nextInt();
        int y1 = in.nextInt();

        int x2 = in.nextInt();
        int y2 = in.nextInt();

        int x3 = in.nextInt();
        int y3 = in.nextInt();


        if ((x2-x1) * (y3-y1) == (x3-x1) * (y2-y1)) {
            System.out.println(-1);
            return;
        }

        double ab = getLength(x1, y1, x2, y2);
        double bc = getLength(x2, y2, x3, y3);
        double ac = getLength(x1, y1, x3, y3);

        double max = Math.max(ab,Math.max(bc,ac));
        double min = Math.min(ab,Math.min(bc,ac));

        System.out.println(2 * (max - min));
    }

    private static double getLength(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }
}
