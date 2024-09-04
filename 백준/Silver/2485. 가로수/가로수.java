import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int result = 0;
        int n = Integer.parseInt(in.nextLine());
        int[] arr = new int[n];
        int[] diffArr = new int[n-1];
        for (int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(in.nextLine());
        }
        
        for (int i = 0; i < n-1; i++) {
        	diffArr[i] = arr[i+1] - arr[i];
        }
        
        int gcd = gcd(diffArr);
        
        int idx = 0;
        for (int i = arr[0]; i <= arr[n-1]; i+=gcd) {
        	if (arr[idx] == i) {
        		idx++;
        	} else {
        		result++;
        	}
        }
        System.out.println(result);
    }
    
    public static int gcd(int[] arr) {
    	int result = arr[0];
    	for (int i = 1; i < arr.length; i++) {
    		while (arr[i] > 0) {
    			int tmp = result;
    			result = arr[i];
    			arr[i] = tmp % arr[i];
    		}
    	}
    	
    	return result;
    }
}
