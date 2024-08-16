class Solution {
    public String[] solution(String[] quiz) {
        String[] result = new String[quiz.length];
        
        int index = 0;
        for (String quizQuestion : quiz) {
            String[] parts = quizQuestion.split(" ");
            int firstOperand = Integer.parseInt(parts[0]);
            int secondOperand = Integer.parseInt(parts[2]);
            
            String operator = parts[1];
            
            int expectedResult = Integer.parseInt(parts[4]);
            
            if (operator.equals("-") && firstOperand - secondOperand == expectedResult) {
                result[index++] = "O";
            } 
            else if (operator.equals("+") && firstOperand + secondOperand == expectedResult) {
                result[index++] = "O";
            } else {
                result[index++] = "X";
            }
        }
        
        return result;
    }
}
