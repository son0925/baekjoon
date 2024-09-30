class Solution {
    fun solution(x: Int): Boolean {
        var n = 0
        var num = x
        
        while (num > 0) {
            n += num % 10
            num /= 10
        }
        
        return x % n == 0
        
    }
}