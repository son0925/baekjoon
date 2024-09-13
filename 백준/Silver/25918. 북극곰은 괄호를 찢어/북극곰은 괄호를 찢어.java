import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = Integer.parseInt(in.nextLine());
        
        String bracket = in.nextLine();
        
        Stack<Character> stk = new Stack<>();
        
        int result = 0;
        
        for (char c : bracket.toCharArray()) {
        	// 비었을 때 추가하고 다음 괄호 확인
        	if (stk.isEmpty()) {
        		stk.push(c);
        	}
        	
        	// O 이거나 X 일 때
        	else if (stk.peek() == '(' && c == ')' || stk.peek() == ')' && c == '(') {
        		stk.pop();
        		continue;
        	}
        	
        	else {
        		stk.push(c);
        	}
        	result = Math.max(result, stk.size());
        }
        
        if (!stk.isEmpty()) {
        	result = -1;
        }
        
        System.out.println(result);
    }
}