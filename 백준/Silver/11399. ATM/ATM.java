import java.util.*;

class Main {
	public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	
    	int n = in.nextInt();
    	in.nextLine();
    	
    	String[] arr = in.nextLine().split(" ");
    	for (int i = 0; i < n; i++) {
    		pq.add(Integer.parseInt(arr[i]));
    	}
    	
    	int result = 0;
    	int wait = 0;
    	
    	while (!pq.isEmpty()) {
    		int time = pq.poll() + wait;
    		result += time;
    		wait = time;
    	}
    	
    	System.out.println(result);
	}
}