import java.util.*;

class Solution {
    // 각 로봇 경로 저장 queue는 로봇 int[] 경로
    static Queue<int[]>[] recode;
    // 로봇 갯수
    static int n;
    // 정답 제출
    static int result;
    
    public int solution(int[][] points, int[][] routes) {
        n = routes.length;
        recode = new LinkedList[n];
        
        for (int i = 0; i < n; i++) {
            recode[i] = new LinkedList<>();
        }
        // 레코드에 각 로봇 경로 기록하기
        recoding(points, routes);
        
        // count하기
        dangerousCounting();
        
        return result;
    }
    
    public void dangerousCounting() {
        int count = 0;
        
        while (count < n) {
            
            int[][] map = new int[101][101];
            count = 0;
            
            for (int i = 0; i < n; i++) {
                if (recode[i].isEmpty()) {
                    count++;
                    continue;
                }
                
                int[] tmp = recode[i].poll();
                map[tmp[0]][tmp[1]]++;
            }
            
            for (int i = 0; i < 101; i++) {
                for (int j = 0; j < 101; j++) {
                    if (map[i][j] > 1) result++;
                }
            }
        }
    }
    
    public void recoding(int[][] points, int[][] routes) {
        // 로봇의 수만큼 반복하기
        for (int i = 0; i < n; i++) {
            // 시작 위치 라우터 찍기
            int[] route = routes[i];
            int x = points[route[0] - 1][1];
            int y = points[route[0] - 1][0];
            
            // 레코드 기록하기
            recode[i].add(new int[] {x,y});
            
            // 다음 목표 위치 찍기
            for (int j = 1; j < route.length; j++) {
                int px = points[route[j] - 1][1];
                int py = points[route[j] - 1][0];
                
                // y좌표부터 이동하기
                while (py != y) {
                    if (py > y) y++;
                    else y--;
                    
                    recode[i].add(new int[]{x,y});
                }
                // x좌표 이동하기
                while (px != x) {
                    if (px > x) x++;
                    else x--;
                    
                    recode[i].add(new int[]{x,y});
                }
            }
        }
    }
}