import java.util.*;

class Solution {
    public int solution(String s) {
        int result = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for (String str : s.split(" ")) {
            if (str.equals("Z") && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }
}