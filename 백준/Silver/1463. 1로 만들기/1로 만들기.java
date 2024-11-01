import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	
	static HashMap<Integer,Integer> map = new HashMap<>();
	
    public static void main(String[] args) throws IOException {
        
    	Scanner in = new Scanner(System.in);
    	
    	
    	N = in.nextInt();
    	
    	
    	int[] arr = new int[N+1];
    	Arrays.fill(arr, Integer.MAX_VALUE);
    	arr[1] = 0;
    	
    	for (int i = 2; i <= N; i++) {
    		if (i % 3 == 0) {
    			arr[i] = arr[i / 3];
    		}  
    		
    		if (i % 2 == 0) {
    			arr[i] = Math.min(arr[i/2], arr[i]);
    		} 
    		
    		arr[i] = Math.min(arr[i], arr[i-1]);
    		
    		arr[i]++;
    	}
    	
    	
    	System.out.println(arr[N]);
    }
}