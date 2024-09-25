class Solution {
    fun solution(numbers: IntArray): Double {
        var result: Double = .0
        
        for (number in numbers) {
            result += number
        }
        
        return result / numbers.size
    }
}