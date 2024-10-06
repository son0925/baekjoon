class Solution {
    fun solution(arr: IntArray): IntArray {
        var minNum = Integer.MAX_VALUE
        
        arr.forEach {
            minNum = Math.min(it, minNum);
        }
        
        var result = arr.filter{ it != minNum }.toIntArray()
        
        if (result.size == 0) {
            return IntArray(1){-1}
        }
        
        return result
    }
}