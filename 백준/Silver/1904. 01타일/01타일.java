import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
    	
    	Scanner in = new Scanner(System.in);
    	
    	
    	int n = in.nextInt();
    	
    	long[] arr = new long[2];
    	arr[0] = 1;
    	arr[1] = 2;
    	
    	if (n <= 2) {
    		System.out.println(arr[n-1]);
    		return;
    	}
    	
    	
    	while (n-- > 1) {
    		long tmp = arr[0];
    		arr[0] = arr[1];
    		arr[1] += tmp % 15746;
    	}
    	
    	System.out.println(arr[0] % 15746);
    }
}