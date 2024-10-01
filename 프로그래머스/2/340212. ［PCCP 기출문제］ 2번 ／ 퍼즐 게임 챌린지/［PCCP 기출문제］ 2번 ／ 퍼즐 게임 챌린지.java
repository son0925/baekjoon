class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        long left = 1;
        long right = getMaxLevel(diffs);
        
        while(left < right){
            long mid = (left + right) >> 1;
            
            if(isImPossible(diffs, times, mid, limit)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        
        return (int) left;
    }
    
    public boolean isImPossible(int[] diffs, int[] times, long level, long limit) {
        long curTime = 0;
        
        for (int i = 0; i < diffs.length; i++) {
            
            if (diffs[i] > level) {
                curTime += (times[i-1] + times[i]) * (diffs[i] - level);
            }
            curTime += times[i];
            
        }
        
        return curTime > limit;
    }
    
    public long getMaxLevel(int[] diffs) {
        long result = 0;
        
        for (int i = 0; i < diffs.length; i++) {
            result = Math.max(result, diffs[i]);
        }
        
        return result;
    }
}