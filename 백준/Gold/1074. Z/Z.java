import java.util.*;

class Main {

    static int num = 0;  
    static int r, c;    

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = (int) Math.pow(2, in.nextInt()); 
        r = in.nextInt();  
        c = in.nextInt(); 

        recursion(0, 0, n); 
    }

    public static void recursion(int x, int y, int size) {
        if (size == 1) { 
            System.out.println(num);
            return;
        }

        int half = size / 2; 

        if (r < x + half && c < y + half) {
            recursion(x, y, half);
        } else {
            num += half * half;  
        }

        if (r < x + half && c >= y + half) {
            recursion(x, y + half, half);
        } else {
            num += half * half;
        }

        if (r >= x + half && c < y + half) {
            recursion(x + half, y, half);
        } else {
            num += half * half;
        }

        if (r >= x + half && c >= y + half) {
            recursion(x + half, y + half, half);
        }
    }
}
