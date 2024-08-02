import java.util.*;

class Solution {
    static HashMap<String,Integer> map = new HashMap<>();

    public String[] solution(String[] players, String[] callings) {
        // 각 플레이어의 초기 순위를 저장할 HashMap 초기화
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        // callings 배열을 순회하며 호출된 플레이어의 순위를 변경
        for (String calling : callings) {
            // 호출된 플레이어의 현재 순위를 map에서 가져옴
            int idx = map.get(calling);
            // 플레이어 위치 교환 메소드 호출
            playerSwap(players, idx);
        }

        // 최종적으로 변경된 players 배열 반환
        return players;
    }
    
    // 플레이어의 순위를 교환하는 메소드
    static void playerSwap(String[] players, int idx) {
        // 호출된 플레이어와 그 앞 플레이어의 위치를 변경
        String tmp = players[idx - 1];
        players[idx - 1] = players[idx];
        players[idx] = tmp;

        // map에서 각 플레이어의 순위를 업데이트
        map.put(players[idx], idx);
        map.put(players[idx - 1], idx - 1);
    }
}
