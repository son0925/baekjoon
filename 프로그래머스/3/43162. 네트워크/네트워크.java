import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int result = 0;
        
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                result++;
                dfs(computers, visited, i);
            }
        }
        
        return result;
    }
    
    static void dfs(int[][] computers, boolean[] visited, int k) {
        visited[k] = true;
        
        for (int i = 0; i < computers.length; i++) {
            if (i != k && !visited[i] && computers[k][i] == 1) {
                dfs(computers, visited, i);
            }
        }
    }
    
    static void bfs(int[][] computers, boolean[] visited, int k) {
        visited[k] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        
        while(!queue.isEmpty()) {
            int nk = queue.poll();
            
            for (int i = 0; i < visited.length; i++) {
                if (nk != i && !visited[i] && computers[nk][i] == 1) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        
    }
}