class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        
        int[] result = new int[2];
        int n = (board[0] - 1) / 2, m = (board[1] - 1) / 2;
        
        for (String key : keyinput) {
            if (key.equals("left") && result[0]-1 >= -n) result[0]--;
            else if (key.equals("right") && result[0]+1 <= n) result[0]++; 
            else if (key.equals("down") && result[1]-1 >= -m) result[1]--;
            else if (key.equals("up") && result[1]+1 <= m) result[1]++; 
        }
        
        return result;
    }
}