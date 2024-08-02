import java.util.*;

class Solution {
    static HashMap<String,Integer> map = new HashMap<>();
    public String[] solution(String[] players, String[] callings) {
        
        // key : 플레이어이름, value : 순위
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (String calling : callings) {
            int idx = map.get(calling);
            playerSwap(players, idx);
        }
        
        return players;
    }
    
    
    static void playerSwap(String[] players, int idx) {
        // players 배열 위치 변경
        String tmp = players[idx-1];
        players[idx-1] = players[idx];
        players[idx] = tmp;
        
        // map 변경하기
        map.put(players[idx], idx);
        map.put(players[idx-1], idx-1);
    }
}