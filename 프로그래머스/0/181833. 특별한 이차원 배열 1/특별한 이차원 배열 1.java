class Solution {
    public int[][] solution(int n) {
        // n x n 크기의 2차원 배열을 생성
        int[][] result = new int[n][n];
        
        // 각 행과 열을 반복하면서
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 행과 열이 같으면 주대각선이므로 1을 대입
                if (i == j) {
                    result[i][j] = 1;
                }
            }
        }
        
        // 생성된 단위 행렬을 반환
        return result;
    }
}
