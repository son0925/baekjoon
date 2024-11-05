import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    static int T;
    
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        
        T = in.nextInt();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < T; i++) {
        	int n1 = in.nextInt();
        	int n2 = in.nextInt();
        	
        	
        	int n = Math.max(n1, n2);
        	int r = Math.min(n1, n2);
        	
        	sb.append(permutation(n, r)).append("\n");
        }
        
        System.out.println(sb);
    }
    
    public static BigInteger factorial(int n) {
    	BigInteger result = BigInteger.ONE;
    	
    	for (int i = 2; i <= n; i++) {
    		result = result.multiply(BigInteger.valueOf(i));
    	}
    	
    	return result;
    }
    
    public static BigInteger permutation(int n, int r) {
    	BigInteger numerator = factorial(n);
    	BigInteger denominator = factorial(r).multiply(factorial(n-r));
    	
    	return numerator.divide(denominator);
    }
}