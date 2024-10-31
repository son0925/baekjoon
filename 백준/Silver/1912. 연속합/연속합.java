import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	
    public static void main(String[] args) throws IOException {
        
        Scanner in = new Scanner(System.in);
        
        N = in.nextInt();
        
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
        	arr[i] = in.nextInt();
        }
        
        int max = arr[0];
        for (int i = 1; i < N; i++) {
        	arr[i] = Math.max(arr[i-1]+arr[i], arr[i]);
        	max = Math.max(max, arr[i]);
        }
        
        System.out.println(max);
    }
}