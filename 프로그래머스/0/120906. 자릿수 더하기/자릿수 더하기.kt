class Solution {
    fun solution(n: Int): Int {
        var result = 0
        var num = n
        
        while (num > 0) {
            result += num % 10
            num /= 10
        }
        
        return result
    }
}