class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        
        int idx = 0;
        for (int[] query : queries) {
            int s = query[0];
            int e = query[1];
            int k = query[2];
            
            int minNum = Integer.MAX_VALUE;
            for (int i = s; i <=e; i++) {
                if (arr[i] > k && arr[i] < minNum) {
                    minNum = arr[i];
                }
            }
            if (minNum < Integer.MAX_VALUE)
                result[idx++] = minNum;
            else
                result[idx++] = -1;
                
        }
        return result;
    }
}