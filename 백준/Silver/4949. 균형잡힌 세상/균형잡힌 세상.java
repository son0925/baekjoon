import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String input = in.nextLine();
        Stack<Character> stk = new Stack<>();
        
        while (input.charAt(0) != '.') {
        	boolean isAble = true;
        	stk.clear();
        	input = input.replaceAll("[a-zA-Z.]*", "");
        	input = input.replaceAll("\\s++", "");
        	for (char c : input.toCharArray()) {
        		
        		// stk이 비어있는지
        		if (stk.isEmpty() || c == '(' || c == '[') {
        			stk.add(c);
        		}
        		
        		
        		else if ((stk.peek() == '(' && c == ')') || (stk.peek() == '[' && c == ']')) {
        			stk.pop();
        		}
        		
        		
        		else {
        			isAble = false;
        			break;
        		}
        		
        		
        	}
        	if (isAble && stk.isEmpty())
    			System.out.println("yes");
    		else
    			System.out.println("no");
        	
        	input = in.nextLine();
        }
    }
}