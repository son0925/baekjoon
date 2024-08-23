import java.util.*;

class Solution {
    public int solution(int[] order) {
        int result = 0;
        int idx = 0;
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= order.length; i++) {
            if (order[idx] == i) {
                result++;
                idx++;
            } else if (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
                result++;
                i--;
            } else {
                stack.add(i);
            }
        }
        
        while (!stack.isEmpty()) {
            if (stack.peek() == order[idx]) {
                stack.pop();
                result++;
                idx++;
            } else {
                break;
            }
        }
        
        return result;
    }
}