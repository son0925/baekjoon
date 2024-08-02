import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String,Integer> playerMap = new HashMap<>();
        HashMap<Integer,String> rankMap = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i);
        }
        for (int i = 0; i < players.length; i++) {
            rankMap.put(i, players[i]);
        }
        
        
        for (String backPlayer : callings) {
            int rank = playerMap.get(backPlayer);
            String frontPlayer = rankMap.get(rank-1);
            rankMap.put(rank-1, backPlayer);
            rankMap.put(rank, frontPlayer);
            playerMap.put(backPlayer, rank-1);
            playerMap.put(frontPlayer, rank);
        }
        
        List<String> result = new ArrayList<>(playerMap.keySet());
        Collections.sort(result, (o1,o2) -> playerMap.get(o1).compareTo(playerMap.get(o2)));
        
        return result.toArray(new String[result.size()]);
    }
    
    static void playerSwap(String[] players, int index) {
        String tmp = players[index-1];
        players[index-1] = players[index];
        players[index] = tmp;
    }
}