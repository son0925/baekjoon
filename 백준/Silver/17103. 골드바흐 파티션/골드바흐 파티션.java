import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	
	static HashMap<Integer,Integer> map = new HashMap<>();
	
    public static void main(String[] args) throws IOException {
        
        Scanner in = new Scanner(System.in);
        
        N = in.nextInt();
        
        initPrimeList();
        
        for (int i = 0; i < N; i++) {
        	
        	int num = in.nextInt();
        	int result = 0;
        	
        	for (int j = 2; j <= num / 2; j++) {
        		if (map.getOrDefault(j, 0) == 1 && map.getOrDefault(num-j, 0) == 1) {
        			result += 1;
        		}
        	}
        	
        	System.out.println(result);
        	
        }
    }
    
    public static void initPrimeList() {
    	for (int i = 2; i <= 1000000; i++) {
        	if (isPrime(i)) {
        		map.put(i, 1);
        	}
        }
    }
    
    public static boolean isPrime(int num) {
    	
    	for (int i = 2; i < (int)Math.sqrt(num) + 1; i++) {
    		if (num % i == 0) return false;
    	}
    	
    	return true;
    }
}