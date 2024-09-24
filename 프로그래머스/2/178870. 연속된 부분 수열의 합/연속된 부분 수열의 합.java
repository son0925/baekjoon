class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] result = new int[2];
        
        int s = 0;
        int e = 0;
        
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (e < sequence.length) {
            sum += sequence[e++];
            
            while (sum > k) {
                sum -= sequence[s++];
            }
            
            if (sum == k && min > e - s - 1 ) {
                result[0] = s;
                result[1] = e-1;
                min = e - s - 1;
            }
            
        }
        
        
        return result;
    }
}