import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
    	
    	Scanner in = new Scanner(System.in);
    	
    	
    	int n = in.nextInt();
    	
    	int m = in.nextInt();
    	
    	int min = Math.min(n, m);
    	in.nextLine();
    	
    	String[] arr = new String[n];
    	
    	for (int i = 0; i < n; i++) {
    		arr[i] = in.nextLine();
    	}
    	
    	// size
    	for (int i = min-1; i >= 1; i--) {
    		for (int j = 0; j < n-i; j++) {
    			for (int k = 0; k < m-i; k++) {
    				Set<Character> set = new HashSet<>();
    				
    				set.add(arr[j].charAt(k));
    				set.add(arr[j].charAt(k+i));
    				set.add(arr[j+i].charAt(k));
    				set.add(arr[j+i].charAt(k+i));
    				
    				if (set.size() == 1) {
    					System.out.println((int)Math.pow(i+1,2));
    					return;
    				}
    			}
    		}
    	}
    	System.out.println(1);
    	
    }
}