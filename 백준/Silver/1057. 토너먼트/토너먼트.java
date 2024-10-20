import java.util.*;

class Main {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        in = new Scanner(System.in);
        
        int n, pos1, pos2, round;
        
        n = in.nextInt();
        pos1 = in.nextInt();
        pos2 = in.nextInt();
        round = 0;
        
        while (pos1 != pos2) {
        	pos1 = (pos1-1) / 2 + 1;
        	pos2 = (pos2-1) / 2 + 1;
        	round++;
        }
        
        System.out.println(round);
    }
}