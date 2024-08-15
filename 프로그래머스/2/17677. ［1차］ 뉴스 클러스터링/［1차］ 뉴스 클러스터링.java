import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 소문자로 변환
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // str1, str2 다중집합
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        multipleSets(list1, str1);
        multipleSets(list2, str2);
        
        // 소수점을 계산하기 위해 double로 선언
        double union = 0.0;
        double intersection = 0.0;
        
        // 자카드 유사도 구하기
        if (list1.size() == 0 && list2.size() == 0) {
            // 서로 공백일 때 완전 일치이므로 65536 return
            return 65536;
        }
        
        for (int i = 0; i < list1.size(); i++) {
            String str = list1.get(i);
            
            // 교집합 조건
            if (list2.contains(str)) {
                intersection++;
                list2.remove(str); // 중복된 단어가 있을 수 있으니 제거
            }
            union++;
        }
        // union + list2.size() list1의 모든 요소는 합집합에 추가 했지만 매칭이 되지 않은 list2의 요소의 갯수를 합집합에 넣어줘야함
        return (int) (intersection / (union + list2.size()) * 65536);
    }
    
    static void multipleSets(List list, String str) {
        for (int i = 0; i < str.length()-1; i++) {
            // 2글자씩 자르고 알파벳이 아니면 empty로 바꾸기
            String s = str.substring(i,i+2).replaceAll("[^a-zA-Z]", "");
            // 2글자가 아니면 조건에 맞지 않음
            if (s.length() == 2)
                list.add(s);
        }
    }
}