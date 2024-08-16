import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        Double[] avgScore = new Double[score.length];
        int n = score[0].length;    // 과목 수
        
        for (int i = 0; i < score.length; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += score[i][j];
            }
            avgScore[i] = sum * 1. / n;
        }
        
        int[] result = new int[score.length];
        List<Double> list = new ArrayList<>(Arrays.asList(avgScore));
        Collections.sort(list, Collections.reverseOrder());
        
        for (int i = 0; i < avgScore.length; i++) {
            result[i] = list.indexOf(avgScore[i]) + 1;
        }
        
        return result;
        
    }
}