class Solution {
    public int solution(String my_string) {
        
        String[] strArr = my_string.split(" ");
        int result = Integer.parseInt(strArr[0]);
        
        // 연산자에 따라 피연산자 저장하는 변수
        int num = 0;
        for (int i = 1; i < strArr.length; i++) {
            // 피연산자
            if (i % 2 == 0) {
                num *= Integer.parseInt(strArr[i]);
                result += num;
            }
            // 연산자 +
            else if (strArr[i].equals("+")){
                num = 1;
            }
            // 연산자 -
            else {
                num = -1;
            }
        }
        return result;
        
        
    }
}