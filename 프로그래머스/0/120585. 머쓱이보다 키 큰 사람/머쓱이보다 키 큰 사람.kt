class Solution {
    fun solution(array: IntArray, height: Int): Int {
        var result:Int = 0
        
        for (i in array) {
            if (height < i) result++
        }
        
        return result
    }
}