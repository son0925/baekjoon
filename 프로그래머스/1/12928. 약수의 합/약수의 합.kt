class Solution {
    fun solution(n: Int): Int {
        var result = 0
        
        for (i in 1..n) {
            if (n % i == 0) {
                result += i
            }
        }
        
        return result
    }
}