import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	
    	Scanner in = new Scanner(System.in);
    	
    	int N = in.nextInt();
    	int[] rope = new int[N];
    	
    	for (int i = 0; i < N; i++) {
    		rope[i] = in.nextInt();
    	}
    	
    	Arrays.sort(rope);
    	
    	
    	int max = rope[N-1];
    	int k = 2;
    	for (int i = N-2; i >= 0; i--) {
    		max = Math.max(max, rope[i] * k++);
    	}
    	
    	System.out.println(max);
    }

}