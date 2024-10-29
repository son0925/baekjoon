import java.util.*;

class Main {
	
	static int N;
	static int S;
	
	public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	
    	int result = Integer.MAX_VALUE;
        
    	N = in.nextInt();
    	S = in.nextInt();
    	
    	int[] arr = new int[N];
    	
    	for (int i = 0; i < N; i++) {
    		arr[i] = in.nextInt();
    	}
    	
    	int s = 0;
    	int e = 0;
    	int sum = arr[0];
    	
    	while (s < N) {
    		
    		if (sum < S && e + 1 < N) {
    			e++;
    			sum += arr[e];
    		}
    		
    		else if (sum < S && e + 1 == N) {
    			break;
    		}
    		
    		else if (sum >= S) {
    			result = Math.min(result, e-s+1);
    			sum -= arr[s];
    			s++;
    		}
    		
    	}
    	
    	if (result == Integer.MAX_VALUE) {
    		System.out.println(0);
    	} else {
    		System.out.println(result);
    	}
	}
}