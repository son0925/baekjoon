class Solution {
    public int solution(int n, int[] stations, int w) {
        int result = 0;
        
        int pos = 1; // 현재 위치는 1부터 시작
        
        for (int station : stations) {
            int l = station - w;
            int r = station + w;
            
            if (l < 0) l = 0;
            if (r > n) r = n;
            
            // 현재 기지국이 영향을 미치지 않는 구역 처리
            if (pos < l) {
                result += (l - pos) % (2 * w + 1) == 0 ? (l - pos) / (2 * w + 1) : (l - pos) / (2 * w + 1) + 1;
            }
            
            // 현재 위치를 기지국이 커버하는 오른쪽 끝으로 이동
            pos = r + 1;
        }
        
        // 마지막 기지국 이후 남은 구역 처리
        if (pos <= n) {
            result += (n - pos + 1) % (2 * w + 1) == 0 ? (n - pos + 1) / (2 * w + 1) : (n - pos + 1) / (2 * w + 1) + 1;
        }
        
        return result;
    }
}
