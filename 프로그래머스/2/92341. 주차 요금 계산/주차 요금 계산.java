import java.util.*;

class Solution {
    static HashMap<String, Integer> parkingNumber;
    static HashMap<String, Integer> parkingDB;
    static Set<String> numberSet;
    public int[] solution(int[] fees, String[] records) {
        parkingNumber = new HashMap<>();
        parkingDB = new HashMap<>();
        numberSet = new HashSet<>();  // 차량 중복 확인을 위한 Set
        
        // records 순차적으로 탐색
        for (String record : records) {
            String[] infoArr = record.split(" ");
            
            // 현재 시간
            String[] curTime = infoArr[0].split(":");
            // 차량 번호
            String number = infoArr[1];
            // true, false로 입차, 출차 확인
            boolean isEnter = infoArr[2].equals("IN");
            
            int curMinutes = Integer.parseInt(curTime[0]) * 60 + Integer.parseInt(curTime[1]);
            
            // 입차일 때
            if (isEnter) carIn(number, curMinutes);
            // 출차일 때
            else carOut(number, curMinutes);
        }
        
        // 아직 나가지 않은 차량 23:59분으로 처리하기
        List<String> numberList = new ArrayList<>(numberSet);
        for (String number : numberList) {
            // 23:59 => 1439분
            carOut(number, 1439);
        }
        Collections.sort(numberList);
        int[] result = new int[numberList.size()];
        // List에 있는 차량 번호 순서대로 DB에 저장된 시간을 계산하여 요금으로 처리하기
        for (int i = 0; i < numberList.size(); i++) {
            String number = numberList.get(i);
            result[i] = getFare(fees, parkingDB.get(number));
        }
        
        return result;
    }
    
    // 요금 계산 메소드
    public static int getFare(int[] fees, int time) {
        int baseMinutes = fees[0]; // 기본 시간
        int baseFare = fees[1];    // 기본 요금
        int additionalMinutes = fees[2];  // 추가 시간
        int additionalFare = fees[3]; // 추가 요금
        
        int result = baseFare;
        
        if (time <= baseMinutes) {
            return result;
        }
        
        // 초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림합니다.
        int diffMin = time - baseMinutes;
        result += Math.ceil((double) diffMin / additionalMinutes) * additionalFare;
        
        return result;
    }
    
    // 입차 메소드(현재 주차되지 않은 상태 parkingNumber에 저장하고 numberList 저장)
    public static void carIn(String number, int curMinutes) {
        parkingNumber.put(number, curMinutes);
                
        // 차량 추가하기
        numberSet.add(number);
    }
    
    // 출차 메소드(현재 주차되어 있는 상태 parkingNumber.get()하고 삭제하기, 주차 내역 저장하기)
    public static void carOut(String number, int curMinutes) {
        if (parkingNumber.containsKey(number)) {
            int parkingTime = parkingNumber.get(number);
            parkingNumber.remove(number);

            parkingDB.put(number, parkingDB.getOrDefault(number, 0) + curMinutes - parkingTime);
        }
    }
}
