/**
LRU : 가장 오랫동안 참조하지 않는 페이지를 교체하는 알고리즘
hit : 1초
miss : 5초

1. 자료구조 : ArrayList
2. 로직 :
ArrayList의 요소가 0에 가까울 수록 가장 오랫동안 참조하지 않음
cities 배열을 순차적으로 실행
cache에 요소가 있는지 파악을 한다.
    있다면 +1초 cache 업데이트(해당 요소를 삭제하고 추가 -> 최근에 참조한 것으로)
    없다면 +5초 cache 업데이트(해당 요소를 추가)
    
    만약 cacheSize가 넘는다면 제일 앞의 요소를 삭제
*/

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        // 실행 시간
        int result = 0;
        
        // 캐시 (index가 0에 가까울 수록 오랫동안 참조하지 않음)
        List<String> cache = new ArrayList<>();
        
        // cities배열 순차적으로 실행
        for (String city : cities) {
            // 모두 소문자로 변환
            city = city.toLowerCase();
            int idx = cache.indexOf(city);
            
            // 캐시에 저장된 도시일 때
            if (idx >= 0) {
                cache.remove(idx);  // 캐시에서 요소 삭제 후 추가
                cache.add(city);    
                result += 1;
            } else {
                cache.add(city);
                result += 5;
            }
            
            // 캐시가 저장할 수 있는 크기를 초과했을 때
            if (cache.size() > cacheSize) {
                cache.remove(0);        // 가장 오랫동안 참조하지 않은 도시 삭제
            }
        }
        
        return result;
    }
}