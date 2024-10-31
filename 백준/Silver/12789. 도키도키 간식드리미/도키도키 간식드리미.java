import java.util.*;

class Main {
	
	static int N; 
	
	public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	
    	N = in.nextInt();
    	Queue<Integer> q = new LinkedList<>();
    	Stack<Integer> stk = new Stack<>();
    	
    	for (int i = 0; i < N; i++) {
    		q.add(in.nextInt());
    	}
    	
    	
    	int curNumber = 1;
    	
    	
    	while (true) {
    		// 큐가 비어있지 않고 현재 숫자와 같다면
    		if (!q.isEmpty() && q.peek() == curNumber) {
    			q.poll();
    			curNumber++;
    		}
    		
    		// 스택이 비어있지 않고 현재 숫자와 같다면
    		else if (!stk.isEmpty() && stk.peek() == curNumber) {
    			stk.pop();
    			curNumber++;
    		}
    		
    		// 둘 다 맞지 않고 q가 비어있지 않다면 q에서 stk로 이동하기
    		else if (!q.isEmpty()) {
    			stk.add(q.poll());
    		}
    		
    		// 만약 다 비어있다면 출력하기
    		else if (q.isEmpty() && stk.isEmpty()){
    			System.out.println("Nice");
    			break;
    		}
    		
    		// 아니라면 Sad 출력
    		else {
    			System.out.println("Sad");
    			break;
    		}
    	}
	}
}