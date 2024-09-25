class Solution {
    fun solution(n: Int): IntArray {
        var answer: IntArray = IntArray(n / 2 + n % 2, {i -> 1 + i * 2})
        return answer
    }
}