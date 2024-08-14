class Solution {
    static int result = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        combination(dungeons, visited, 0, k);
        return result;
    }
    
    public static void combination(int[][] dungeons, boolean[] visited, int count, int k) {
        result = Math.max(result, count);
        
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                combination(dungeons, visited, count+1, k-dungeons[i][1]);
                visited[i] = false;
            }
        }
    }
}