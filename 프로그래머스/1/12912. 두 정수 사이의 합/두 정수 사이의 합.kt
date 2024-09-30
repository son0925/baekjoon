class Solution {
    fun solution(a: Int, b: Int): Long {
        var result:Long = 0
        
        var min = Math.min(a, b)
        var max = Math.max(a, b)
        
        for (i in min..max) {
            result += i
        }
        
        return result
    }
}