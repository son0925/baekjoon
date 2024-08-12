class Solution {
    public int solution(int[] arr) {
        int result = 0;
        boolean isFinal = false;
        while (!isFinal) {
            isFinal = true;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 50 && arr[i] % 2 == 0) {
                    arr[i] /= 2;
                    isFinal = false;
                }
                else if(arr[i] < 50 && arr[i] % 2 == 1) {
                    arr[i] = arr[i] * 2 + 1;
                    isFinal = false;
                }
            }
            result++;
        }
        
        return result-1;
    }
}