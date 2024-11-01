import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	
	static HashMap<Integer,Integer> map = new HashMap<>();
	
    public static void main(String[] args) throws IOException {
        
    	Scanner in = new Scanner(System.in);
    	
    	
    	N = in.nextInt();
    	
    	int[] arr = new int[11];
    	arr[0] = 1;
    	for (int i = 1; i < 11; i++) {
    		int sum = 0;
    		
    		for (int j = i-3 >= 0 ? i-3 : 0;  j < i; j++) {
    			sum += arr[j];
    		}
    		
    		arr[i] = sum;
    	}
    	
    	
    	for (int i = 0; i < N; i++) {
    		System.out.println(arr[in.nextInt()]);
    	}
    }
}