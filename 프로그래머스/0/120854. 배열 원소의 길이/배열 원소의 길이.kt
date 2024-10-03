class Solution {
    fun solution(strlist: Array<String>): IntArray {
        val result = mutableListOf<Int>()
        for (s in strlist) {
            result.add(s.length)
        }
        return result.toIntArray()
        
    }
}