import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer,int[]> map = mapSetting();
        
        int[] leftIndex = {3,0};
        int[] rightIndex = {3,2};
        
        for (int n : numbers) {
            int[] indexArr = map.get(n);
            int x = indexArr[0];
            int y = indexArr[1];
            if (y == 0) {
                sb.append("L");
                leftIndex = indexArr;
            }
            else if (y == 2) {
                sb.append("R");
                rightIndex = indexArr;
            }
            // 손가락 위치에 따라, 주로 사용하는 손에 따라 결정하기
            else {
                int lx = leftIndex[0];
                int ly = leftIndex[1];
                int rx = rightIndex[0];
                int ry = rightIndex[1];
                
                int lIndex = Math.abs(lx - x) + Math.abs(ly - y);
                int rIndex = Math.abs(rx - x) + Math.abs(ry - y);
                
                if (lIndex < rIndex) {
                    sb.append("L");
                    leftIndex = indexArr;
                }
                else if (rIndex < lIndex) {
                    sb.append("R");
                    rightIndex = indexArr;
                } else {
                    if (hand.equals("right")) {
                        sb.append("R");
                        rightIndex = indexArr;
                    } else {
                        sb.append("L");
                        leftIndex = indexArr;
                    }
                }
            }
        }
        
        
        return sb.toString();
    }
    
    static HashMap<Integer,int[]> mapSetting() {
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