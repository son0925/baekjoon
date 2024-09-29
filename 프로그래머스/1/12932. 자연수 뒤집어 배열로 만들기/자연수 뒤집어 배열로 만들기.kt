class Solution {
    fun solution(n: Long): IntArray {
        val result = n.toString()
            .reversed()
            .map {it.digitToInt()}
            .toIntArray()
        
        return result
    }
}