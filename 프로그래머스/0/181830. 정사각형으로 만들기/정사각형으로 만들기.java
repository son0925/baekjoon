class Solution {
    public int[][] solution(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        
        int n = Math.max(row, col);
        
        int[][] result = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (col > j && row > i) {
                    result[i][j] = arr[i][j];
                } else {
                    result[i][j] = 0;
                }
            }
        }
        
        return result;
    }
}