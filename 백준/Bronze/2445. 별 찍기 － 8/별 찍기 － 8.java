import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = Integer.parseInt(in.nextLine());
        
        for (int i = 0; i < n*2-1; i++) {
        	for (int j = 0; j < n*2; j++) {
        		
        		// 별이 커질 때
        		if (i < n) {
        			if (i >= j || n*2-i-1 <= j) {
        				System.out.print("*");
        			} else {
        				System.out.print(" ");
        			}
        		}
        		
        		// 별이 줄어들 때 
        		else {
        			if (i < j || 2*n-1-i > j) {
        				System.out.print("*");
        			} else {
        				System.out.print(" ");
        			}
        		}
        		
        		
        	}
        	System.out.println();
        }
    }
}