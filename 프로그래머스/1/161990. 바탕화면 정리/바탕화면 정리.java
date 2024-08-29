class Solution {
    public int[] solution(String[] wallpaper) {
        // 0 : minY, 1 : minX, 2 : maxY 3 : maxX
        int[] result = new int[4];
        
        for (int i = 0; i < 4; i++) {
            if (i < 2)
                result[i] = Integer.MAX_VALUE;
            else
                result[i] = Integer.MIN_VALUE;
        }
        
        
        for (int i = 0; i < wallpaper.length; i++) {
            String line = wallpaper[i];
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == '#') {
                    result[0] = Math.min(result[0], i);
                    result[1] = Math.min(result[1], j);
                    result[2] = Math.max(result[2], i+1);
                    result[3] = Math.max(result[3], j+1);
                }
            }
        }
        
        return result;
    }
}