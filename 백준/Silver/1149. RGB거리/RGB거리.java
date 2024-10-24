import java.util.*;

class Main {
	
	static int n;
	static int result = Integer.MAX_VALUE;
	static int[][] colors;
	
	public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	
    	n = in.nextInt();
    	in.nextLine();
    	
    	colors = new int[n][3];
    	
    	for (int i = 0; i < n; i++) {
    		String[] arr = in.nextLine().split(" ");
    		
    		for (int j = 0; j < 3; j++) {
    			colors[i][j] = Integer.parseInt(arr[j]);
    		}
    	}
    	

    	for (int i = 1; i < n; i++) {
    		for (int j = 0; j < 3; j++) {
        		int min = Integer.MAX_VALUE;
    			for (int k = 0; k < 3; k++) {
    				if (j != k) {
    					min = Math.min(colors[i-1][k], min);
    				}
    			}
    			
    			colors[i][j] += min;
    		}
    	}
    	
    	for (int i = 0; i < 3; i++) {
    		result = Math.min(result, colors[n-1][i]);
    	}
    	
    	System.out.println(result);
	}
}