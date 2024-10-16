import java.util.*;

class Solution {
    
    String[] userId;
    String[] bannedId;
    Set<Set<String>> uniqueSet = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        
        userId = user_id;
        bannedId = banned_id;
        
        boolean[] visit = new boolean[userId.length];
        dfs(visit, 0, new HashSet<>());
        
        return uniqueSet.size();
    }
    
    public void dfs(boolean[] visit, int idx, Set<String> currentSet) {
        if (idx == bannedId.length) {
            uniqueSet.add(new HashSet<>(currentSet));
            return;
        }
        
        for (int i = 0; i < userId.length; i++) {
            if (!visit[i] && checkId(userId[i], bannedId[idx])) {
                visit[i] = true;
                currentSet.add(userId[i]);
                dfs(visit, idx + 1, currentSet);
                visit[i] = false;
                currentSet.remove(userId[i]);
            }
        }
    }
    
    
    public boolean checkId(String id, String compareId) {
        if (id.length() != compareId.length()) return false;
        for (int i = 0; i < id.length(); i++) {
            if (compareId.charAt(i) != '*' && id.charAt(i) != compareId.charAt(i)) 
                return false;
        }
        return true;
    }
}