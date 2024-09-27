class Solution {
    fun solution(message: String): Int {
        // var result = message.length * 2
        
        var result = 0
        for (s in message) {
            result += 2
        }
        
        
        return result
    }
}