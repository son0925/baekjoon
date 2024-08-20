class Solution {
    public int solution(String dartResult) {
        // 숫자가 나왔을 때(새로운 라운드) lastPoint를 result에 더하고 lastPoint = currentPoint로 변경하고 currentPoint = n으로 변경하기
        // S,D,T가 나왔을 때 currentPoint 에 해당 옵션만큼 제곱해주기
        // *이 나왔을 때 lastPoint와 currentPoint를 2 곱해주기
        // #이 나왔을 때 currentPoint를 -1로 곱해주기
        int result = 0;
        int lastPoint = 0;
        int currentPoint = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            
            // c 가 1이라면 1인지 10인지 확인하기(숫자일 때 처리까지)
            if (c == '1' && dartResult.charAt(i+1) == '0') {
                result += lastPoint;
                lastPoint = currentPoint;
                currentPoint = 10;
                i++;
                continue;
            }
            // 10이 아니고 한자리 숫자일 때
            if (c >= '0' && c <= '9') {
                result += lastPoint;
                lastPoint = currentPoint;
                currentPoint = c - '0';
                continue;
            }
            
            
            // S,D,T가 나왔을 때
            if (c == 'S') {
                continue;
            } else if (c == 'D') {
                currentPoint *= currentPoint;
                continue;
            } else if (c == 'T') {
                currentPoint *= currentPoint * currentPoint;
                continue;
            }
            
            
            // *, #이 나왔을 때
            if (c == '*') {
                lastPoint *= 2;
                currentPoint *= 2;
            } else if (c == '#') {
                currentPoint *= -1;
            }
        }
        
        result += lastPoint + currentPoint;
        
        
        return result;
    }
}