class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] result = new int[numlist.length];
        
        int[] distance = new int[numlist.length];
        
        for (int i = 0; i < numlist.length; i++) {
            distance[i] = Math.abs(n - numlist[i]);
        }
        
        int resultIndex = 0;
        
        for (int i = 0; i < distance.length; i++) {
            int minDis = Integer.MAX_VALUE;
            int idx = -1;
            for (int j = 0; j < distance.length; j++) {
                if (distance[j] == -1) continue;
                
                if (minDis > distance[j]) {
                    minDis = distance[j];
                    idx = j;
                } 
                // 현재 minDis와 거리가 같고 숫자가 더 클 때
                else if (minDis == distance[j] && numlist[idx] < numlist[j]){
                    minDis = distance[j];
                    idx = j;
                }
            }
            distance[idx] = -1;
            result[resultIndex++] = numlist[idx];
        }
        
        return result;
    }
}