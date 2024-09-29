class Solution {
    fun solution(n: Long): IntArray {
        val result = mutableListOf<Int>()
        var num = n
        
        while (num > 0) {
            result.add((num % 10).toInt())
            num /= 10
        }
        
        return result.toIntArray()
    }
}