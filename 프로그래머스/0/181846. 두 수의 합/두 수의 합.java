class Solution {
    public String solution(String a, String b) {
        StringBuilder result = new StringBuilder();
        StringBuilder sbA = new StringBuilder(a);
        StringBuilder sbB = new StringBuilder(b);
        sbA.reverse();
        sbB.reverse();
        
        int n = Math.max(sbA.length(), sbB.length());
        
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            int numA, numB;
            if (sbA.length() > i) {
                numA = sbA.charAt(i) - '0';
            } else {
                numA = 0;
            }
            
            if (sbB.length() > i) {
                numB = sbB.charAt(i) - '0';
            } else {
                numB = 0;
            }
            
            int num = numA + numB;
            if (flag) {
                num++;
            }
            
            if (num >= 10) {
                flag = true;
                num %= 10;
            } else {
                flag = false;
            }
            
            result.append(num);
            
        }
        
        if (flag) {
            result.append(1);
        }
        return result.reverse().toString();
    }
}