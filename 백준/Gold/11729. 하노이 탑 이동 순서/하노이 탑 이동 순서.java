import java.util.*;

class Main {
	
	static int n;
	static int count = 0;
	static Stack<Integer>[] stack = new Stack[3];
	static StringBuilder recode = new StringBuilder();
	static final String format = "%s %s\n";
	
	public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	n = in.nextInt();
    	
    	initHanoi();
    	
    	
    	hanoi(n, 0, 2, 1);
    	
    	System.out.println(count);
    	System.out.println(recode);
	}
	
	public static void hanoi(int disk, int from, int to, int aux) {
		if (disk == 1) {
			moveDisk(from, to);
			return;
		}
		
		hanoi(disk - 1, from, aux, to);
		
		moveDisk(from, to);
		
		hanoi(disk - 1, aux, to, from);
	}
	
	public static void moveDisk(int from, int to) {
		stack[to].push(stack[from].pop());
		count++;
		recode.append(String.format(format, from+1, to+1));
	}
	
	
	public static void initHanoi() {
		for (int i = 0; i < 3; i++) {
    		stack[i] = new Stack<Integer>();
    	}
    	
    	for (int i = n; i >= 1; i--) {
    		stack[0].push(i);
    	}
	}
}