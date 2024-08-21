import java.util.*;

class Solution {
    static HashMap<String, Integer> parkingInTime; // 차량이 입차된 시간을 기록하는 맵
    static HashMap<String, Integer> parkingTotalTime; // 차량의 총 주차 시간을 기록하는 맵
    static Set<String> vehicleSet; // 차량 번호 중복 체크를 위한 세트

    public int[] solution(int[] fees, String[] records) {
        parkingInTime = new HashMap<>();
        parkingTotalTime = new HashMap<>();
        vehicleSet = new HashSet<>();
        
        // 모든 기록을 순차적으로 처리
        for (String record : records) {
            String[] infoArr = record.split(" ");
            String[] curTime = infoArr[0].split(":");
            String number = infoArr[1];
            boolean isEnter = infoArr[2].equals("IN");
            int curMinutes = Integer.parseInt(curTime[0]) * 60 + Integer.parseInt(curTime[1]);
            
            if (isEnter) {
                carIn(number, curMinutes);
            } else {
                carOut(number, curMinutes);
            }
        }
        
        // 출차 기록이 없는 차량을 23:59에 출차 처리
        List<String> vehicleList = new ArrayList<>(vehicleSet);
        for (String number : vehicleList) {
            if (parkingInTime.containsKey(number)) {
                carOut(number, 1439); // 23:59에 출차
            }
        }

        // 차량 번호를 오름차순으로 정렬
        Collections.sort(vehicleList);
        int[] result = new int[vehicleList.size()];
        
        // 각 차량의 총 주차 시간을 바탕으로 요금 계산
        for (int i = 0; i < vehicleList.size(); i++) {
            String number = vehicleList.get(i);
            result[i] = calculateFare(fees, parkingTotalTime.get(number));
        }
        
        return result;
    }

    // 요금 계산 메소드
    public static int calculateFare(int[] fees, int time) {
        int baseTime = fees[0];
        int baseFare = fees[1];
        int unitTime = fees[2];
        int unitFare = fees[3];

        if (time <= baseTime) {
            return baseFare;
        }

        int extraTime = time - baseTime;
        int additionalFare = (int) Math.ceil((double) extraTime / unitTime) * unitFare;

        return baseFare + additionalFare;
    }

    // 입차 처리 메소드
    public static void carIn(String number, int curMinutes) {
        parkingInTime.put(number, curMinutes);
        vehicleSet.add(number);
    }

    // 출차 처리 메소드
    public static void carOut(String number, int curMinutes) {
        if (parkingInTime.containsKey(number)) {
            int inTime = parkingInTime.get(number);
            parkingInTime.remove(number);

            parkingTotalTime.put(number, parkingTotalTime.getOrDefault(number, 0) + curMinutes - inTime);
        }
    }
}
