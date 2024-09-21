class Solution {
    
    int[] result = new int[2];
    
    public int[] solution(int[][] arr) {
        
        // 그림, x, y, size
        compress(arr, 0, 0, arr.length);
        
        return result;
    }
    
    public void compress(int[][] arr, int x, int y, int size) {
        
        // 현재 그림의 x, y 부터 시작하는 좌표에서 size의 크기가 압축이 가능한지
        if (isAbleCompress(arr, x, y, size)) {
            result[arr[x][y]] ++;
            return;
        }
        
        
        
        // 압축이 불가능하다면 size를 축소하여 계속 비교하기
        int curSize = size / 2;
        
        compress(arr, x, y, curSize);
        compress(arr, x, y + curSize, curSize);
        compress(arr, x + curSize, y, curSize);
        compress(arr, x + curSize, y + curSize, curSize);
    }
    
    
    public boolean isAbleCompress(int[][] arr, int x, int y, int size) {
        int targetNum = arr[x][y];
        
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (targetNum != arr[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}