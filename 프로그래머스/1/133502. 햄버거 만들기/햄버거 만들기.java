import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < ingredient.length; i++) {
            stack.push(ingredient[i]);
            
            // 스택의 크기가 4 이상인 경우에만 패턴 검토
            if (stack.size() >= 4) {
                // 마지막 4개의 요소를 확인하여 패턴 [1, 2, 3, 1] 확인
                if (stack.get(stack.size() - 1) == 1 &&
                    stack.get(stack.size() - 2) == 3 &&
                    stack.get(stack.size() - 3) == 2 &&
                    stack.get(stack.size() - 4) == 1) {
                    
                    result++;
                    stack.pop(); // 1 제거
                    stack.pop(); // 3 제거
                    stack.pop(); // 2 제거
                    stack.pop(); // 1 제거
                }
            }
        }
        
        return result;
    }
}
