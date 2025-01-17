import java.util.*;

class Main {
	
	static int N; 
	
	public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	
    	N = in.nextInt();
    	
    	PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
    		int abCompare = Integer.compare(Math.abs(a), Math.abs(b));
    		return abCompare != 0 ? abCompare : Integer.compare(a, b);
    	});
    	
    	for (int i = 0; i < N; i++) {
    		int num = in.nextInt();
    		
    		if (num == 0) {
    			if (pq.isEmpty()) {
    				System.out.println(0);
    			} else {
    				System.out.println(pq.poll());
    			}
    		} else {
    			pq.add(num);
    		}
    	}
	}
}