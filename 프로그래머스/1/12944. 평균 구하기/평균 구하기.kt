class Solution {
    fun solution(arr: IntArray): Double {
        var result = 0
        
        for (num in arr) {
            result += num
        }
        
        
        return result.toDouble() / arr.size
    }
}