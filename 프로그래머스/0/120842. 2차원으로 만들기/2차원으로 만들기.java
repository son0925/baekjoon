class Solution {
    public int[][] solution(int[] num_list, int n) {
        int tmp = num_list.length / n;
        int m = n;
        n = tmp;
        int[][] result = new int[n][m];
        
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = num_list[index++];
            }
        }
        
        return result;
    }
}