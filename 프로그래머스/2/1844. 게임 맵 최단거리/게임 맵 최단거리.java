import java.util.*;

class Solution {
    
    // 맵 길이 n, m
    static int n, m;
    
    // 정답 제출 변수(최댓값으로 설정 : 최단거리를 구하는 문제 + 도착을 못할 시 -1로 해야함)
    static int result = Integer.MAX_VALUE;
    
    // 방문 여부
    static boolean[][] visited;
    
    // x, y의 이동할 수 있는 경우의 수 4가지 배열 생성
    static final int[] dx = {1,0,-1,0};
    static final int[] dy = {0,1,0,-1};
    
    public int solution(int[][] maps) {
        // 맵 크기 저장
        n = maps.length;
        m = maps[0].length;
        
        // 방문 여부 배열 생성
        visited = new boolean[n][m];
        
        // BFS 메소드 실행
        bfs(maps);
        
        // 맵 끝에 도착을 못할 시
        if (result == Integer.MAX_VALUE)
            return -1;
        
        // 최단 거리 도착
        return result;
    }
    
    static void bfs(int[][] maps) {
        // x, y, count를 저장할 큐 생성
        Queue<int[]> queue = new LinkedList<>();
        // x : 0, y : 0, count : 1로 시작하기
        // count를 넣는 이유는 하나의 좌표에서 이동할 수 있는 길이 2개일 경우 
        // 분기별로 count를 따로 저장하기 위해서
        queue.add(new int[]{0,0,1});
        visited[0][0] = true;
        
        // 큐가 비어질 때 까지 실행하기
        // 큐가 비어지는 경우는 더 이상 이동할 길이 없을 때
        while (!queue.isEmpty()) {
            // 큐에서 int[] 배열 하나 추출
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];
            
            // x, y 좌표 4가지 경우의 수 이동하기
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // maps의 범위를 넘지 않을 때 + 해당 위치에 방문 X + 해당 위치 값 1
                if (nx >= 0 && ny >= 0 && nx < n && ny < m &&
                   !visited[nx][ny] && maps[nx][ny] == 1) {
                    // count + 1, queue에 해당 좌표 count 넣기, 방문 표시하기
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, count+1});
                    
                    // 만약 nx와 ny의 값이 맵 끝에 도착했을 때 최솟값 저장하기
                    if (nx == n-1 && ny == m-1) {
                        result = Math.min(result, count+1);
                    }
                }
            }
        }
    }
}