import java.util.*;

class Main {
	
	static int n;
	
	public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        
        n = in.nextInt();
        int count = in.nextInt();
        
        
        boolean[] visit = new boolean[n+1];
        
        StringBuilder sb = new StringBuilder();
        
        recursion(visit, count, sb);
    }
    
    public static void recursion(boolean[] visit, int count, StringBuilder sb) {
    	if (count == 0) {
    		System.out.println(sb.toString().trim());
    		return;
    	}
    	
    	for (int i = 1; i <= n; i++) {
    		if (!visit[i]) {
    			visit[i] = true;
    			sb.append(i + " ");
    			recursion(visit, count-1, sb);
    			sb.setLength(sb.length() - 2);
    			visit[i] = false;
    		}
    	}
    }
}