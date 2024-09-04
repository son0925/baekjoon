import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = Integer.parseInt(in.nextLine());
        
        for (int i = 0; i < n; i++) {
        	long target = Long.parseLong(in.nextLine());
        	
        	while (true) {
        		if (isPrime(target)) {
        			break;
        		}
        		target++;
        	}
        	System.out.println(target);
        }
    }
    
    public static boolean isPrime(long n) {
    	if (n <= 1) return false;
    	if (n == 2 || n == 3) return true;
    	
    	for (int j = 2; j < (int) Math.sqrt(n)+1; j++) {
    		if (n % j == 0) return false;
    	}
    	
    	return true;
    }
}
