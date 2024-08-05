import java.util.*;

class Solution {
    
    static int[] leftPos = {3,0};
    static int[] rightPos = {3,2};
    static boolean isRight;
    static HashMap<Integer,int[]> map;
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        // 번호 위치 설정
        map = numbersPosition();
        // 손 설정
        isRight = hand.equals("right");
        
        for (int n : numbers) {
            int[] pos = map.get(n);
            
            String s = handPos(pos);
            
            if (s.equals("R")) rightPos = pos;
            else leftPos = pos;
            sb.append(s);
        }
        
        return sb.toString();
    }
    
    static String handPos(int[] pos) {
        if (pos[1] == 0) return "L";
        else if (pos[1] == 2) return "R";
        
        if (getDist(pos)) return "R";
        else return "L";
    }
    
    static boolean getDist(int[] pos) {
        int leftDist = Math.abs(pos[0] - leftPos[0]) + Math.abs(pos[1] - leftPos[1]);
        int rightDist = Math.abs(pos[0] - rightPos[0]) + Math.abs(pos[1] - rightPos[1]);
        
        if (leftDist > rightDist) return true;
        else if (leftDist < rightDist) return false;
        
        return isRight;
    }
    
    static HashMap<Integer,int[]> numbersPosition() {
        int[][] numbersArr = {{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
        HashMap<Integer,int[]> map = new HashMap<>();
        for (int i = 0; i < numbersArr.length; i++) {
            for (int j = 0; j < numbersArr[i].length; j++) {
                int key = numbersArr[i][j];
                int[] value = {i,j};
                
                if (key != -1)
                    map.put(key, value);
            }
        }
        
        return map;
    }
}