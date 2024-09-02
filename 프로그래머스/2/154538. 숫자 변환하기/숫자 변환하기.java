import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        return bfs(x, y, n);
    }
    
    int bfs(int x, int y, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, 0});
        boolean[] visited = new boolean[y+1];
        
        while (!q.isEmpty()) {
            int[] tmpArr = q.poll();
            int currNum= tmpArr[0];
            int count = tmpArr[1];
            
            if (currNum == y) return count;
            
            if (currNum + n <= y && !visited[currNum+n]) {
                q.add(new int[] {currNum+n, count+1});
                visited[currNum+n] = true;
            }
            if (currNum * 2 <= y && !visited[currNum*2]) {
                q.add(new int[] {currNum*2, count+1});
                visited[currNum*2] = true;
            }
            if (currNum * 3 <= y && !visited[currNum*3]) {
                q.add(new int[] {currNum*3, count+1});
                visited[currNum*3] = true;
            }
        }
        return -1;
    }
}