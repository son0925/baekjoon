import java.util.*;

class Main {
	
	public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        
    	int n = in.nextInt();
    	in.nextLine();
    	
    	Deque<String> q = new LinkedList<>();
    	
    	
    	for (int i = 0; i < n; i++) {
    		String[] command = in.nextLine().split(" ");
    		
    		if (command[0].equals("push")) {
    			q.add(command[1]);
    		} 
    		
    		else if (command[0].equals("empty")) {
    			if (q.isEmpty()) {
    				System.out.println(1);
    			} else {
    				System.out.println(0);
    			}
    		}
    		
    		else if (command[0].equals("size")) {
    			System.out.println(q.size());
    		}

    		else {
    			if (q.isEmpty()) {
    				System.out.println(-1);
    			}
    			
    			else if (command[0].equals("front")) {
        			System.out.println(q.peekFirst());
        		}
    			
    			else if (command[0].equals("pop")) {
        			System.out.println(q.poll());
        		}

        		else if (command[0].equals("back")) {
        			System.out.println(q.peekLast());
        		} 
    		}
    	}
	}
}