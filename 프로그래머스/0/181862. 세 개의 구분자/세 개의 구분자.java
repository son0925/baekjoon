import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        // a,b,c 일 때 문자열을 담을 list와 StringBuilder
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        // 문자열의 문자를 확인하는 반복문
        for (int i = 0; i < myStr.length(); i++) {
            char c = myStr.charAt(i);
            
            // a,b,c 중 하나이면서 저장된 단어가 있다면
            if ((c == 'a' || c == 'b' || c == 'c') && sb.length() > 0) {
                list.add(sb.toString()); // 리스트에 저장
                sb.setLength(0);  // 배열 길이를 0으로 변환(초기화)
            } 
            // a,b,c가 아니라면 저장하기
            else if (c != 'a' && c != 'b' && c != 'c'){
                sb.append(c);
            }
        }
        
        // 아직 저장된 문자가 있다면 list에 저장하기
        if (sb.length() > 0) {
            list.add(sb.toString());
        }
        
        // list에 아무것도 없을 때
        if (list.size() == 0) {
            return new String[]{"EMPTY"};
        }
        
        // 정답을 담을 배열 생성
        String[] result = new String[list.size()];
        // 배열에 요소 담기
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}