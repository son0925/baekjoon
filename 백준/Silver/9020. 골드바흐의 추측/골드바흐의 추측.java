import java.util.*;
import java.io.*;

public class Main {
	
	static List<Integer> primeList;
	
    public static void main(String[] args) throws IOException {
    	
    	primeList = initPrimeList();
        
    	Scanner in = new Scanner(System.in);
    	
    	
    	int N = in.nextInt();
    	
    	for (int i = 0; i < N; i++) {
    		int n = in.nextInt();
    		
    		int result = goldbackConjecture(n);
    		
    		if (result > 0) {
    			System.out.println(result + " " + (n-result));
    		}
    	}
    }
    
    public static int goldbackConjecture(int n) {
    	
    	for (int i = n / 2; i >= 2; i--) {
    		if (primeList.contains(i) && primeList.contains(n - i)) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    
    public static List<Integer> initPrimeList() {
    	List<Integer> list = new ArrayList<>();
    	
    	for (int i = 2; i <= 10000; i++) {
    		if (isPrime(i)) {
    			list.add(i);
    		}
    	}
    	
    	
    	return list;
    }
    
    
    public static boolean isPrime(int num) {
    	for (int i = 2; i < (int)Math.sqrt(num)+1; i++) {
    		if (num % i == 0) 
    			return false;
    	}
    	
    	return true;
    }
}