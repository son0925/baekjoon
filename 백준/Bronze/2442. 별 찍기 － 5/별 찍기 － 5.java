import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = Integer.parseInt(in.nextLine());
        
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (n - i - 1 < j) {
        			System.out.print("*".repeat(2));
        		} 
        		else if (n - i - 1 == j) {
        			System.out.print("*");
        		} else {
        			System.out.print(" ");
        		}
        	}
        	System.out.println();
        }
    }
}