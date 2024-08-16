class Solution {
    public int solution(int[] sides) {
        int result = 0;
        int min = Math.min(sides[0], sides[1]);
        
        return min * 2 - 1;
    }
}