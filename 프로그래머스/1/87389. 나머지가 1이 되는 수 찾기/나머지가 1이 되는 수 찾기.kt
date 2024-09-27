class Solution {
    fun solution(n: Int): Int {
        var result = 0
        
        for (i in 1..n-1) {
            if (n % i == 1) {
                result = i
                break
            }
        }
        
        return result
    }
}