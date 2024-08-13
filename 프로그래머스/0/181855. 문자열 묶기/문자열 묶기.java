class Solution {
    public int solution(String[] strArr) {
        // 배열의 원소 길이를 index로 파악하여 갯수를 저장하는 배열
        int[] lenArr = new int[31]; // 31인 이유 zeroBase이기 때문에 -1로 저장하면 30해도 됨
        
        for (String s : strArr) {
            // index로 배열 갯수 저장
            lenArr[s.length()]++;
        }
        
        int result = 0;
        
        for (int i = 0; i < lenArr.length; i++) {
            if (result < lenArr[i]) {
                result = lenArr[i];
            }
        }
        
        return result;
    }
}