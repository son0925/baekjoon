class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        var result = arr.sorted().filter {it % divisor == 0} .toIntArray()
        if (result.size == 0) 
            return IntArray(1) {-1}
        return result
    }
}