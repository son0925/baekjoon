class Solution {
    fun solution(angle: Int): Int {
        var result:Int = 0
        
        when(angle) {
            in 1 until 90 -> result = 1
            90 -> result = 2
            in 91 until 180 -> result = 3
            180 -> result = 4
        }
        
        
        return result
    }
}