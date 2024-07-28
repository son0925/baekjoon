class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        // 반환하는 배열 길이 구하기
        int n = 0;
        for (int i = 0; i < intervals.length; i++) {
            n += intervals[i][1] - intervals[i][0] + 1;
        }
        int[] result = new int[n];
        
        int index = 0;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = intervals[i][0]; j <= intervals[i][1]; j++) {
                result[index++] = arr[j];
            }
        }
        
        return result;
    }
}