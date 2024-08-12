import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        
        int[] result = new int[n];
        boolean[][] isReport = new boolean[n][n];
        int[] counting = new int[n];
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.put(id_list[i], i);
        }
        
        for (int i = 0; i < report.length; i++) {
            String[] tmp = report[i].split(" ");
            
            int x = map.get(tmp[0]);
            int y = map.get(tmp[1]);
            if (!isReport[x][y]) {
                counting[y] += 1;
                isReport[x][y] = true;
            }
        }
        
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (isReport[i][j] && counting[j] >= k) {
                    count++;
                }
            }
            result[i] = count;
        }
        
        return result;
    }
}