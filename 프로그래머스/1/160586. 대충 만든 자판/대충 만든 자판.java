class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] result = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            
            // target의 원소 하나씩 keymap 비교하기
            for (int j = 0; j < target.length(); j++) {
                // minNum은 int의 최댓값으로 설정
                int minNum = Integer.MAX_VALUE;
                
                for (String key : keymap) {
                    int idx = key.indexOf(target.charAt(j));
                    
                    if (idx > -1) {
                        minNum = Math.min(minNum, idx);
                    }
                }
                
                if (minNum < Integer.MAX_VALUE && result[i] != -1) {
                    result[i] += minNum + 1;
                } else {
                    result[i] = -1;
                }
            }
            
        }
        return result;
    }
}