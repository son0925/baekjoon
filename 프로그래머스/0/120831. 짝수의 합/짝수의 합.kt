class Solution {
    fun solution(n: Int): Int {
        var result: Int = 0
        
        // for (i: Int in 2..n step(2))
        //     result += i
        
        // 1~n까지
        for (i: Int in 1 until n+1) {
            if (i % 2 == 0) result += i
        }
            
        return result
    }
}