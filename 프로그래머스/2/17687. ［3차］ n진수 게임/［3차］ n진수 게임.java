class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder result = new StringBuilder();
        
        int currentNumber = 0;
        int currentTurn = 0;
        
        while (result.length() < t) {
            String convertedNumber = convertedNumberToBase(currentNumber, n);
            for (char c : convertedNumber.toCharArray()) {
                if (currentTurn == p - 1) {
                    result.append(c);
                }
                
                if (result.length() == t) {
                    return result.toString();
                }
                currentTurn = (currentTurn + 1) % m;
            }
            currentNumber++;
        }
        
        return result.toString();
    }
    
    
    static String convertedNumberToBase(int number, int base) {
        StringBuilder result = new StringBuilder();
        String[] alpha = {"A","B","C","D","E","F"};
        if (number == 0) {
            return "0";
        }
        
        while (number > 0) {
            int remainder = number % base;
            
            if (remainder >= 10) {
                result.append(alpha[remainder - 10]);
            } else {
                result.append(remainder);
            }
            
            number = number / base;
        }
        
        return result.reverse().toString();
    }
}