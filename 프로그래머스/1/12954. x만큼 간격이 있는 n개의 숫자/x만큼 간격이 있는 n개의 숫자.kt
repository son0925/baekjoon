class Solution {
    fun solution(x: Int, n: Int): LongArray {
        val result = LongArray(n) {i -> (x.toLong() * (i+1))}
        
        return result
    }
}