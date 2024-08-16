class Solution {
    public int solution(String s) {
        int result = 0;
        // 0번째 index는 targetCount 1번째 index는 otherCount
        int[] countArr = new int[2];
        char target = s.charAt(0);
        
        for (int i = 0; i < s.length(); i++) {
            if (target == s.charAt(i)) {
                countArr[0]++;
            } else {
                countArr[1]++;
            }
            
            if (countArr[0] == countArr[1]) {
                result++;
                countArr = new int[2];
                target = s.charAt((i+1) % s.length());
            }
        }
        
        if (countArr[0] != countArr[1])
            return result + 1;
        return result;
    }
}