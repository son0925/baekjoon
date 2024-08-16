import java.util.*;

class Solution {
    public String solution(String[] id_pw, String[][] db) {
        HashMap<String,String> userMap = new HashMap<>();
        
        for (String[] userInfo : db) {
            userMap.put(userInfo[0], userInfo[1]);
        }
        
        String pw = userMap.get(id_pw[0]);
        
        if (pw == null) {
            return "fail";
        }
        
        if (!id_pw[1].equals(pw)) {
            return "wrong pw";
        }
        return "login";
    }
}