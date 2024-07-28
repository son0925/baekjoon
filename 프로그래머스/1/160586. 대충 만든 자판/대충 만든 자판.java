class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] result = new int[targets.length]; // 결과를 저장할 배열 초기화
        
        // 1. targets 배열에서 각 target 문자열을 하나씩 추출합니다.
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i]; // 현재 타겟 문자열
            
            // 2. 각 target 문자열에서 문자를 하나씩 추출합니다.
            for (char c : target.toCharArray()) {
                int minIdx = Integer.MAX_VALUE; // 최소 인덱스를 저장할 변수
                
                // 3. keymap 배열에 있는 문자열에 대해 indexOf()를 사용하여 최소 위치를 구합니다.
                for (String key : keymap) {
                    int idx = key.indexOf(c); // 키맵에서 문자의 인덱스를 찾음
                    
                    // 해당 idx 가 -1이 아니며 minIdx보다 낮을 때 minIdx에 값 넣기
                    if (idx > -1 && minIdx > idx) {
                        minIdx = idx; // 최소 인덱스 업데이트
                    }
                }
                
                // 4. keymap을 모두 방문했을 때 target 문자열을 완성할 수 없다면 -1을 저장합니다.
                if (minIdx < Integer.MAX_VALUE && result[i] != -1) {
                    result[i] += minIdx + 1; // 인덱스를 1 기반으로 계산하여 누적
                } else {
                    result[i] = -1; // 최소 인덱스를 찾지 못하면 결과를 -1로 설정
                }
            }
        }
        
        return result; // 결과 배열 반환
    }
}
