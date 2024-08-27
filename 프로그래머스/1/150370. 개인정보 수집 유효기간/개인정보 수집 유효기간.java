import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String,Integer> termMap = initMap(terms);
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] infoArr = privacies[i].split(" ");
            
            if (isAble(infoArr, today, termMap)) {
                list.add(i+1);
            }
        }
        
        
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    // 유효 기간이 지났는지
    public boolean isAble(String[] infoArr, String today, HashMap<String,Integer> termMap) {
        // 오늘 날짜
        String[] todayArr = today.split("\\.");
        int nYear = Integer.parseInt(todayArr[0]);
        int nMonth = Integer.parseInt(todayArr[1]);
        int nDay = Integer.parseInt(todayArr[2]);
        
        // 수집 일자
        String[] date = infoArr[0].split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);

        // 약관 종류
        int period = termMap.get(infoArr[1]);

        // 약관에 따른 유효기간 설정
        month += period;
        while (month > 12) {
            month -= 12;
            year++;
        }
        
        
        // 유효기간 지났는지 확인
        if (nYear > year) {
            return true;
        }
        else if (nYear == year && nMonth > month) {
            return true;
        } else if (nYear == year && nMonth == month && nDay >= day) {
            return true;
        }
        
        return false;
        
    }
    // 약정 종류 initMap
    public HashMap<String, Integer> initMap(String[] terms) {
        HashMap<String,Integer> map = new HashMap<>();
        
        for (String term : terms) {
            String[] arr = term.split(" ");
            
            String grade = arr[0];
            int month = Integer.parseInt(arr[1]);
            
            map.put(grade, month);
        }
        return map;
    }
}