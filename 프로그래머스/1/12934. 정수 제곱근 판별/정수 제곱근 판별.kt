class Solution {
    fun solution(n: Long): Long {
        var sqrt = Math.sqrt(n * 1.0).toLong()
        var result: Long = 0
        
        if (sqrt * sqrt == n) {
            sqrt++
            result = sqrt * sqrt
        } else {
            result = -1;
        }
        
        return result
    }
}