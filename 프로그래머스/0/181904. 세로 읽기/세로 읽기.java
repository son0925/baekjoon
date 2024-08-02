class Solution {
    public String solution(String my_string, int m, int c) {
        String result = "";  // 결과 문자열을 저장할 변수
        
        // c-1부터 시작하여 m 간격으로 반복문을 수행
        for (int i = c-1; i < my_string.length(); i += m) {
            result += my_string.charAt(i);  // 문자열에서 해당 인덱스의 문자 추가
        }
        
        return result;  // 결과 문자열 반환
    }
}
