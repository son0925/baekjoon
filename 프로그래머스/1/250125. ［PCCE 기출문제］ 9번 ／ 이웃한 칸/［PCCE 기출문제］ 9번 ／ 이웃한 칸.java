class Solution {
    
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int result = 0;
        
        String color = board[h][w];
        
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + w;
            int ny = dy[i] + h;
            if (nx >= 0 && ny >= 0 && nx < n && ny < n 
                && color.equals(board[ny][nx])) {
                result++;
            }
        }
        
        return result;
    }
}