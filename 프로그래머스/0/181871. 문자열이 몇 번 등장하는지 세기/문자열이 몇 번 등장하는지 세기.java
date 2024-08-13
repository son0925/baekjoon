class Solution {
    public int solution(String myString, String pat) {
        int result = 0; // 패턴이 발견된 횟수를 저장하는 변수
        int n = pat.length(); // 패턴의 길이를 저장하는 변수

        // 문자열 myString의 각 위치에서 패턴 pat의 길이만큼 부분 문자열을 추출하여 비교합니다.
        for (int i = 0; i < myString.length() - n + 1; i++) {
            // i번째 위치부터 시작해서 n개의 문자를 잘라낸 부분 문자열이 패턴과 동일한지 확인합니다.
            if (myString.substring(i, n + i).equals(pat)) 
                result++; // 패턴이 발견되면 카운트를 증가시킵니다.
        }
        
        return result; // 패턴이 발견된 총 횟수를 반환합니다.
    }
}