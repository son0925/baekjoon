class Solution {
    fun solution(n: Int): Int {
        var result = n / 7
        
        if (n % 7 != 0)
            result ++
        
        return result
    }
}