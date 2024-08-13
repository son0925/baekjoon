class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int result = 0;
        
        // 1등부터 3등까지 찾기
        for (int i = 1; i <= 3; i++) {
            int maxRank = Integer.MAX_VALUE;
            int idx = -1;
            for (int j = 0; j < rank.length; j++) {
                // 참가할 수 있고 maxRank보다 낮다면
                if (attendance[j] && maxRank > rank[j]) {
                    idx = j;
                    maxRank = rank[j];
                }
            }
            // 참가 확정이므로 false로 다음 순위를 찾게한다
            attendance[idx] = false;
            
            // 랭킹 별 처리하기
            if (i == 1) {
                result += 10000 * idx;
            } else if (i == 2) {
                result += 100 * idx;
            } else if (i == 3) {
                result += idx;
            }
        }
        return result;
    }
}