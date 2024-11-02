import java.util.*;
import java.io.*;

public class Main {
	
	static boolean[] prime = new boolean[10001];
	
    public static void main(String[] args) throws IOException {
    	
    	Scanner in = new Scanner(System.in);
    	
    	int N = in.nextInt();
    	int target = in.nextInt();
    	
    	int[] coin = new int[N];
    	
    	for (int i = 0; i < N; i++) {
    		coin[i] = in.nextInt();
    	}
    	
    	int result = 0;
    	for (int i = N-1; i >= 0; i--) {
    		result += target / coin[i];
    		target %= coin[i];
    	}
    	
    	System.out.println(result);
    }

}