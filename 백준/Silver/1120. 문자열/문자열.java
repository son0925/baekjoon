import java.util.*;
import java.io.*;

public class Main {
    static int T;
    
    static String A;
    static String B;
    
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        
        A = in.next();
        B = in.next();
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < B.length() - A.length()+1; i++) {
        	min = Math.min(diffCounter(i), min);
        }
        
        
        System.out.println(min);
    }
    
    public static int diffCounter(int idx) {
    	int count = 0;
    	
    	for (int i = 0; i < A.length(); i++) {
    		if (B.charAt(i+idx) != A.charAt(i)) {
    			count++;
    		}
    	}
    	
    	return count;
    }
}