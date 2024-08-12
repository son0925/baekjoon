class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr2[0].length];
        
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = matrixMultiplication(arr1, arr2, i, j);
            }
        }
        
        return result;
    }
    
    public static int matrixMultiplication(int[][] arr1, int[][] arr2, int i, int j) {
        int result = 0;
        
        int index = 0;
        while (index < arr1[0].length || index < arr2.length) {
            result += arr1[i][index] * arr2[index][j];
            index++;
        }
        
        return result;
    }
}