class Solution {
    fun solution(array: IntArray, n: Int): Int {
        // var result = array.filter {it == n}.size
        
        var result = 0
        for (i in array) {
            if (i == n) result ++
        }
        
        return result
    }
}