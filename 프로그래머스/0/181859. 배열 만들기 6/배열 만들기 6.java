import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        // 요소를 담을 스택
        Stack<Integer> stack = new Stack<>();
        
        // i의 초기값을 0으로 설정하고 i가 arr의 길이보다 작으면 다음을 반복합니다.
        for (int i = 0; i < arr.length; i++) {
            // 만약 stk이 빈 배열일 때
            if (stack.isEmpty()) {
                stack.push(arr[i]); // arr[i]를 stk에 추가
                continue;           // i에 1을 더합니다. (continue로 다시 for문 시작 즉 + 1이 됨)
            }
            // stk에 원소가 있고, stk의 마지막 원소가 arr[i]와 같을 때
            if (stack.peek() == arr[i]) {
                stack.pop(); // stk의 마지막 원소를 stk에서 제거
                continue;    // i에 1을 더합니다.
            }
            
            // stk에 원소가 있는데 stk의 마지막 원소가 arr[i]와 다르면 stk의 맨 마지막에 arr[i]를 추가하고 i에 1을 더합니다.
            // 위 if조건을 전부 지났을 때 자동으로 충족되기 때문에 조건문 사용할 필요 없음
            stack.push(arr[i]);
        }
        // 마지막에 빈 배열이 되었으므로 [-1]을 return 합니다.
        if (stack.isEmpty()) {
            return new int[]{-1};
        }
        
        int[] result = new int[stack.size()];
        for (int i = result.length-1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}