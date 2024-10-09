class Solution {
    fun solution(phone_number: String): String {
        var n = phone_number.length
        
        return "*".repeat(n-4) + phone_number.substring(n-4, n)
    }
}