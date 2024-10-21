import java.util.*;

class Main {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        
        int num = 665;
        while (n > 0) {
        	num++;
        	if (String.valueOf(num).contains("666")) {
        		n--;
        	}
        }
        
        System.out.println(num);
        
    }
}