import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	
    public static void main(String[] args) throws IOException {
        
        Scanner in = new Scanner(System.in);
        
        int num = in.nextInt();
        
        while (num != 0) {
        	
        	int result = 0;
        	
        	for (int i = num+1; i <= num * 2; i++) {
        		if (isPrime(i)) {
        			result++;
        		}
        	}
        	
        	System.out.println(result);
        	num = in.nextInt();
        }
    }
    
    public static boolean isPrime(int n) {
    	
    	for (int i = 2; i < (int)Math.sqrt(n) + 1; i++) {
    		if (n % i == 0) return false;
    	}
    	
    	
    	return true;
    }
}