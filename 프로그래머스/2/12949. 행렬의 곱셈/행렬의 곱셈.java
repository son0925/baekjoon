class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 결과 행렬의 크기는 arr1의 행 개수와 arr2의 열 개수에 맞춥니다.
        int[][] result = new int[arr1.length][arr2[0].length];

        // 결과 행렬의 각 요소를 계산합니다.
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = matrixMultiplication(arr1, arr2, i, j);
            }
        }

        return result;
    }

    public static int matrixMultiplication(int[][] arr1, int[][] arr2, int i, int j) {
        int result = 0;

        // arr1의 열의 개수와 arr2의 행의 개수는 같아야 합니다.
        // 이 조건이 맞는 경우, 다음의 연산을 수행합니다.
        for (int index = 0; index < arr1[0].length; index++) {
            result += arr1[i][index] * arr2[index][j];
        }

    return result;
    }

}