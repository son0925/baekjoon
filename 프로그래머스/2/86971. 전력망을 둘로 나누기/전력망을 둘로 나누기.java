import java.util.*;

class Solution {
    
    static boolean[] visit;
    static int[][] map;
    static int result = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        map = new int[n][n];
        
        // 인접 행렬로 연결 정보 저장
        for (int[] wire : wires) {
            map[wire[0]-1][wire[1]-1]++;
            map[wire[1]-1][wire[0]-1]++;
        }
        
        // 모든 전선을 하나씩 끊어보고 최솟값 계산
        cutWire(n);
        
        return result;
    }
    
    void cutWire(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    // 전선 하나를 끊음
                    map[i][j] = 0;
                    map[j][i] = 0;
                    
                    // 방문 배열 초기화
                    visit = new boolean[n];
                    
                    // 첫 번째 네트워크 크기 계산
                    int count1 = dfs(i, n);
                    
                    // 두 번째 네트워크 크기 계산
                    int count2 = dfs(j, n);
                    
                    // 두 네트워크의 크기 차이 계산
                    result = Math.min(result, Math.abs(count1 - count2));
                    
                    // 전선 복구
                    map[i][j] = 1;
                    map[j][i] = 1;
                }
            }
        }
    }
    
    // DFS로 네트워크의 노드 개수 계산
    int dfs(int idx, int n) {
        visit[idx] = true;
        int count = 1; // 현재 노드 포함
        
        for (int i = 0; i < n; i++) {
            if (!visit[i] && map[idx][i] == 1) {
                count += dfs(i, n);
            }
        }
        return count;
    }
}
