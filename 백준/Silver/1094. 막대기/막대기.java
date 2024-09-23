import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int[] stick = {64, 32, 16, 8, 4, 2, 1};
        int count = 0;
        int x = in.nextInt();
        
        for (int i = 0; i < stick.length; i++) {
        	if (x >= stick[i]) {
        		count++;
        		x -= stick[i];
        	}
        	
        	if (x == 0)
        		break;
        }
        
        System.out.println(count);
    }
}
