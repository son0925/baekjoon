import java.util.*;
import java.io.*;

public class Main {
	
	static boolean[] prime = new boolean[10001];
	
    public static void main(String[] args) throws IOException {
    	
    	Scanner in = new Scanner(System.in);
    	
    	int N = in.nextInt();
    	
    	setPrime();
    	
    	for (int i = 0; i < N; i++) {
    		int n = in.nextInt();
    		int left = n / 2;
    		int right = n / 2;
    		
    		while (true) {
    			if (prime[left] && prime[right]) {
    				System.out.println(left + " " + right);
    				break;
    			}
    			
    			left--;
    			right++;
    		}
    	}
    }
    
    public static void setPrime() {
    	for (int i = 0; i < prime.length; i++) {
    		prime[i] = isPrime(i);
    	}
    }
    
    public static boolean isPrime(int num) {
    	
    	for (int i = 2; i < (int)Math.sqrt(num)+1; i++) {
    		if (num % i == 0)
    			return false;
    	}
    	
    	return true;
    	
    }
}