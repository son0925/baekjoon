import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        // 정사각형 보드의 크기
        int n = board.length;
        
        // 터트려져 사라진 인형의 수를 저장할 변수
        int result = 0;
        
        // 인형을 담을 바구니 (Stack 자료구조 사용)
        Stack<Integer> stack = new Stack<>();
        
        // 크레인의 움직임을 나타내는 moves 배열을 순회
        for (int line : moves) {
            // 각 열(column)의 맨 위부터 인형을 찾기 위해 순회
            for (int i = 0; i < n; i++) {
                // 보드의 해당 위치가 비어있으면 (0이면) 다음 위치로 이동
                if (board[i][line - 1] == 0) continue;
                
                // 보드의 해당 위치가 비어있지 않으면 (인형이 있으면)
                // 스택이 비어있을 때: 인형을 바구니에 추가
                if (stack.isEmpty()) {
                    stack.push(board[i][line - 1]);
                } 
                // 스택이 비어있지 않을 때: 바구니 맨 위의 인형과 현재 인형 비교
                else if (stack.peek() == board[i][line - 1]) {
                    // 동일한 인형이면 바구니에서 제거하고 사라진 인형 수를 증가
                    stack.pop();
                    result += 2; // 인형 두 개가 사라지므로 +2
                } 
                // 바구니 맨 위의 인형과 현재 인형이 다르면 바구니에 추가
                else {
                    stack.push(board[i][line - 1]);
                }
                
                // 인형을 뽑았으므로 해당 위치를 0으로 변경
                board[i][line - 1] = 0;
                break; // 다음 moves 실행
            }
        }
        
        // 최종적으로 사라진 인형의 수 반환
        return result;
    }
}
