import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        // 변수 i를 만들어 초기값을 0으로 설정한 후 i가 arr의 길이보다 작으면 다음 작업을 반복합니다.
        for (int i = 0; i < arr.length; i++) {
            // 만약 stk가 빈 배열이라면 arr[i]를 stk에 추가하고 i에 1을 더합니다.
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                continue;
            }
            
            
            // stk에 원소가 있을 때
            // stk의 마지막 원소가 arr[i]보다 작으면 arr[i]를 stk의 뒤에 추가하고 i에 1을 더합니다.
            // stk의 마지막 원소가 arr[i]보다 크거나 같으면 stk의 마지막 원소를 stk에서 제거합니다.
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            
            if (!stack.isEmpty() && stack.peek() < arr[i] || stack.isEmpty()) {
                stack.push(arr[i]);
            }
        }
        int[] result = new int[stack.size()];
        
        for (int i = result.length-1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}