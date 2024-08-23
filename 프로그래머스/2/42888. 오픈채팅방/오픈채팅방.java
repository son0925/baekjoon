import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // key : id, value : name
        HashMap<String,String> userDB = new HashMap<>();
        
        List<String> messageList = new ArrayList<>();
        
        for (String log : record) {
            String[] parts = log.split(" ");
            
            String action = parts[0];
            String userId = parts[1];
            
            // Enter
            if (action.equals("Enter")) {
                String userName = parts[2];
                userDB.put(userId, userName);
                messageList.add(userId + ":님이 들어왔습니다.");
            } 
            // Leave
            else if (action.equals("Leave")) {
                messageList.add(userId + ":님이 나갔습니다.");
            }
            // Change
            else {
                String userName = parts[2];
                userDB.put(userId, userName);
            }
        }
        
        String[] result = new String[messageList.size()];
        for (int i = 0; i < messageList.size(); i++) {
            String[] msgArr = messageList.get(i).split(":");
            String userId = msgArr[0];
            String msg = msgArr[1];
            
            String userName = userDB.get(userId);
            
            result[i] = userName + msg;
        }
        return result;
    }
}