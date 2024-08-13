class Solution {
    public int[][] solution(int n) {
        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};
        
        int[][] result = new int[n][n];
        
        int target = n*n;
        int num = 1;
        int nx = 0, ny = 0;
        int idx = 0;
        while (num <= target) {
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && result[ny][nx] == 0) {
                result[ny][nx] = num++;
            }
            else {
                nx -= dx[idx];
                ny -= dy[idx];
                idx = (idx+1) % 4;
            }
            
            nx += dx[idx];
            ny += dy[idx];
        }
        
        return result;
    }
}