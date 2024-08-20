import java.util.*;

class Solution {
    public int solution(String dirs) {
        // 캐릭터가 처음 걸어본 길의 길이
        int result = 0;
        
        // 길 매핑 -5~5가 아닌 -5를 기준으로 -5~-4를 0으로 기준 잡음 목적지를 방문했는지가 아닌 길을 방문했는지 여부
        boolean[][][] visited = new boolean[11][11][4];
        
        // 현재 플레이어 위치
        int x = 5, y = 5;  // 0~10으로 매핑하기 때문
        // 플레이어 좌표 이동 배열
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        // 플레이어 이동
        for (char c : dirs.toCharArray()) {
            int idx = getIndex(c);  // dx, dy 배열 index
            
            // map을 벗어나지 않았으면 이동하기
            // 이때 그 길을 지나가지 않았다면 result + 1 하기
            if (x + dx[idx] >= 0 && y + dy[idx] >= 0 && x + dx[idx] < 11 && y + dy[idx] < 11) {
                
                if (!visited[x][y][idx]) {
                    result++;
                }
                
                // 방문 목록 최신화 및 플레이어 이동
                visited[x][y][idx] = true;
                x += dx[idx];
                y += dy[idx];
                
                // (0,1) -> (1,1)로 이동했을 때 (1,1) -> (0,1) 로 이동한 길도 true로 바꾸기 똑같은 길이기 때문
                if (idx % 2 == 0) idx++;
                else idx--;
                visited[x][y][idx] = true;
            }
        }
        
        return result;
    }
    
    
    static int getIndex(char c) {
        switch (c) {
            case 'U':
                return 0;
            case 'D':
                return 1;
            case 'R':
                return 2;
            case 'L':
                return 3;
        }
        return -1;
    }
}