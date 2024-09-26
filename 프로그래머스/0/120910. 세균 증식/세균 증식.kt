class Solution {
    fun solution(n: Int, t: Int): Int {
//         var result = n
        
//         for (i in 1..t) {
//             result *= 2
//         }
        
//         return result
        
        
        return Math.pow(2.0, t.toDouble()).toInt() * n
    }
}