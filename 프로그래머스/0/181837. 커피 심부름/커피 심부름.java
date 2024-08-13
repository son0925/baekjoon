class Solution {
    public int solution(String[] orders) {
        // 값을 저장할 변수
        int result = 0;
        
        for (String order : orders) {
            if (order.contains("latte")) { // 라때만
                result += 5000;
            } else { // 아메리카노 + 아무거나
                result += 4500;
            }
        }
        
        return result;
    }
}