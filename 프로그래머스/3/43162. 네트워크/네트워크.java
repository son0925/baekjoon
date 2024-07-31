import java.util.*;


/**
 1. 2중 for문을 돌면서 자기 자신을 제외한 다른 1을 파악하여 해당 1이 있는 idx에 대해 반복한다.
 2. 조건에 맞다면 dfs 메소드를 호출하여 조건에 맞을 때 queue에 저장하면서 자신과 연관되어있는 모든 배열에 대해 방문을 표시한다.
 3. 연결된 모든 컴퓨터를 확인하면 dfs를 종료하고 다음 컴퓨터를 확인한다.
*/
class Solution {
    public int solution(int n, int[][] computers) {
        int result = 0;
        
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                result++;
                bfs(computers, visited, i);
            }
        }
        
        return result;
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