class Solution {
    fun solution(num1: Int, num2: Int): Int {
        var result: Int = 0
        if (num1 == num2) {
            result = 1
        } else {
            result = -1
        }
        
        return result
    }
}