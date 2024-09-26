class Solution {
    fun solution(num1: Int, num2: Int): Int {
        // return num1 * 1000 / num2
        
        var result:Double = 0.0
        result = num1.toDouble() / num2 * 1000
        
        
        return result.toInt()
    }
}