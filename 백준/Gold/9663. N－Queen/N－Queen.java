import java.util.*;
import java.io.*;

public class Main {
	
	static int result = 0;
	
	static int[] arr;
	static int n;
	
    public static void main(String[] args) throws IOException {
    	
    	Scanner in = new Scanner(System.in);
    	
    	n = in.nextInt();
    	
    	arr = new int[n];
    	
    	nQueen(0);
    	System.out.println(result);
    }
    
    public static void nQueen(int depth) {
    	if (depth == n) {
    		result++;
    		return;
    	}
    	
    	for (int i = 0; i < n; i++) {
    		arr[depth] = i;
    		
    		if (possibility(depth)) {
    			nQueen(depth+1);
    		}
    	}
    }
    
    
    public static boolean possibility(int col) {
    	
    	for (int i = 0; i < col; i++) {
    		if (arr[col] == arr[i]) {
    			return false;
    		}
    		
    		else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
    			return false;
    		}
    	}
    	
    	
    	return true;
    	
    }

}