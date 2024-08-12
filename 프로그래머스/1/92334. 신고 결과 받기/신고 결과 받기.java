import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // id_list 배열의 길이를 n으로 정의 (사용자 수)
        int n = id_list.length;
        
        // 최종 결과를 저장할 배열, 모든 요소를 0으로 초기화
        int[] result = new int[n];
        // 사용자가 신고한 내역을 기록할 2차원 boolean 배열
        boolean[][] hasReported = new boolean[n][n];
        // 각 사용자가 받은 신고 횟수를 기록할 배열
        int[] reportCounts = new int[n];
        
        // 사용자 ID를 인덱스와 매핑하기 위해 HashMap 사용
        HashMap<String, Integer> userIndexMap = new HashMap<>();
        
        // id_list 배열을 순회하여 각 사용자 ID에 대해 인덱스를 매핑
        for (int i = 0; i < n; i++) {
            userIndexMap.put(id_list[i], i);
        }
        
        // report 배열을 순회하여 신고 내역을 처리
        for (int i = 0; i < report.length; i++) {
            // 신고 내용을 공백으로 분리하여 신고자와 피신고자 추출
            String[] reportDetails = report[i].split(" ");
            
            int reporterIndex = userIndexMap.get(reportDetails[0]);
            int reportedIndex = userIndexMap.get(reportDetails[1]);
            
            // 동일한 신고는 한 번만 처리되도록 중복 신고 방지
            if (!hasReported[reporterIndex][reportedIndex]) {
                reportCounts[reportedIndex] += 1;
                hasReported[reporterIndex][reportedIndex] = true;
            }
        }
        
        // 각 사용자가 신고한 피신고자의 신고 횟수가 k 이상인 경우 결과 카운트 증가
        for (int i = 0; i < n; i++) {
            int validReportCount = 0;
            for (int j = 0; j < n; j++) {
                if (hasReported[i][j] && reportCounts[j] >= k) {
                    validReportCount++;
                }
            }
            result[i] = validReportCount;
        }
        
        return result;
    }
}
