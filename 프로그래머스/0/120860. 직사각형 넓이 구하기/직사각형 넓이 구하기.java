class Solution {
    public int solution(int[][] dots) {
        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;
        
        for (int i = 0; i < dots.length; i++) {
            if (x1 > dots[i][0]) x1 = dots[i][0];
            if (x2 < dots[i][0]) x2 = dots[i][0];
            if (y1 > dots[i][1]) y1 = dots[i][1];
            if (y2 < dots[i][1]) y2 = dots[i][1];
        }
        
        return (x2 - x1) * (y2 - y1);
    }
}