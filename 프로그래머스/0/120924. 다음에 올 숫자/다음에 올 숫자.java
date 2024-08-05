class Solution {
    public int solution(int[] common) {
        int n = common.length;
        
        if (common[1] - common[0] == common[2] - common[1]) {
            return common[n-1] + common[n-1] - common[n-2];
        }
        
        return common[n-1] * (common[n-1] / common[n-2]);
    }
}