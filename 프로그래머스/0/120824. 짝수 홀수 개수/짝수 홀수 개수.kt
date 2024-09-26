class Solution {
    fun solution(num_list: IntArray): IntArray {
        
        var even = 0
        var odd = 0
        
        for (num in num_list) {
            if (num % 2 == 0) even++
            else odd++
        }
        
        
        var result:IntArray = intArrayOf() 
        result += even
        result += odd
        
        return result
    }
}