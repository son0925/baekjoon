class Solution {
    fun solution(num: Int): Int {
        var result = 0
        var n:Long = num.toLong() // 매개변수 타입은 val로 변경이 불가능
        
        while (n > 1 && result <= 500) {
            
            if (n % 2 == 0.toLong()) n /= 2
            else n = n * 3 + 1
            
            result++
        }
        
        if (result > 500)
            return -1
        
        
        return result
    }
}