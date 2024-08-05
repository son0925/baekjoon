import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        // 정사각형 크기 n * n
        int n = board.length;
        
        // 터트려져 사라진 인형 수
        int result = 0;
        
        // 인형을 담을 바구니
        Stack<Integer> stack = new Stack<>();
        
        // 크래인 작동하기 moves배열을 순서대로 실행하며 line -1을 하여 배열에 접근하기
        for (int line : moves) {
            for (int i = 0; i < n; i++) {
                // 0 : 비어있을 때 continue;
                if (board[i][line-1] == 0) continue;
                
                // 0이 아니며 stack이 비어있을 때 추가하기
                if (stack.isEmpty()) {
                    stack.push(board[i][line-1]);
                }
                
                // 0이 아니며 stack에 요소가 있을 때 제일 위에 있는 인형이 같은거라면 터뜨리고 + 2하기(인형이 2개이기 때문에)
                else if (stack.peek() == board[i][line-1]) {
                    System.out.println("stack : " + stack.peek() + " borad : " + board[i][line-1]);
                    stack.pop();
                    result += 2;
                }
                
                // 0이 아니며 stack에 요소가 있을 때 제일 위에 있는 인형이 다르다면 추가하기
                else {
                    stack.push(board[i][line-1]);
                }
                
                // 인형을 뽑았기 때문에 0으로 바꾸고 다음 moves 실행
                board[i][line-1] = 0;
                break;
            }
        }
        
        return result;
    }
}