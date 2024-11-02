import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
    	Scanner in = new Scanner(System.in);
    	
    	
    	int N = in.nextInt();
    	int M = in.nextInt();
    	
    	
    	System.out.println(gcd(N, M));
    	System.out.println(lcm(N, M));
    }
    
    public static int gcd(int a, int b) {
    	
    	if (b == 0) {
    		return a;
    	}
    	
    	return gcd(b, a%b);
    }
    
    public static int lcm(int a, int b) {
    	return a * b / gcd(a,b);
    }
}