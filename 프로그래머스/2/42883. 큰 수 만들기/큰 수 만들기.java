class Solution {
    public String solution(String number, int k) {
        StringBuilder result = new StringBuilder();
        int s = 0;
        int e = number.length() - k;  // 뽑아야 할 자릿수
        
        for (int i = 0; i < e; i++) {
            char maxNum = '0';
            for (int j = s; j <= k + i; j++) {
                if (number.charAt(j) > maxNum) {
                    maxNum = number.charAt(j);
                    s = j + 1;  
                }
            }
            result.append(maxNum);
        }
        
        return result.toString();
    }
}
