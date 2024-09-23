import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int a,b,c,d,e,f;
        
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();
        d = in.nextInt();
        e = in.nextInt();
        f = in.nextInt();
        
        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                if (a * i + b * j == c && d * i + e * j == f) {
                    System.out.println(i + " " + j);
                    break;
                }
            }
        }
    }
}