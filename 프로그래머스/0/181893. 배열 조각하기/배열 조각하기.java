class Solution {
    public int[] solution(int[] arr, int[] query) {
        int startIndex = 0;
        int endIndex = arr.length-1;
        
        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                endIndex = startIndex + query[i];
            } else {
                startIndex += query[i];
            }
        }
        
        int[] result = new int[endIndex-startIndex+1];
        int index = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            result[index++] = arr[i];
        }
        
        return result;
    }
}