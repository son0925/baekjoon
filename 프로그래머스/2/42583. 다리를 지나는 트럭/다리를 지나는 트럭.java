import java.util.*;

class Truck {
    int weight;
    int remainingLength;
    
    Truck(int w, int l) {
        weight = w;
        remainingLength = l;
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int result = 0;
        int currentWeight = 0;
        
        List<Truck> list = new ArrayList<>();
        for (int w : truck_weights) {
            
            // 현재 대기 중인 트럭이 다리를 건널 수 있을 때까지 반복
            while (currentWeight + w > weight) {
                // 다리 위에 있는 트럭이 1씩 이동하고 시간 추가
                for (int i = list.size()-1; i >= 0; i--) {
                    Truck t = list.get(i);
                    t.remainingLength--;
                    if (t.remainingLength == 0) {
                        currentWeight -= t.weight;
                        list.remove(t);
                    }
                }
                result ++;
            }
            
            // 다음 트럭이 다리를 건너기 시작
            list.add(new Truck(w, bridge_length));
            // 다리 위 트럭 1씩 이동하기
            for (int i = list.size()-1; i >= 0; i--) {
                Truck t = list.get(i);
                t.remainingLength--;
                if (t.remainingLength == 0) {
                    currentWeight -= t.weight;
                    list.remove(t);
                }
            }
            // 다음 트럭 무게 추가
            currentWeight += w;
            result++;
        }
        
        // 모든 트럭이 다리를 건너기 시작했다면 현재 가장 뒤에 있는 트럭 남은 길이를 result 추가
        result += list.get(list.size()-1).remainingLength + 1;
        return result;
    }
}