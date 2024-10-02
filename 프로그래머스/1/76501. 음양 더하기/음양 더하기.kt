class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        var result = 0
        
        for ((idx, el) in absolutes.withIndex()) {
            if (signs[idx]) result += el
            else result -= el
        }
        
        return result
    }
}