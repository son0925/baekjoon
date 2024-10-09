class Solution {
    fun solution(a: IntArray, b: IntArray): Int {
        return a.mapIndexed { idx, el ->
            el * b[idx]
        } .toIntArray() .sum()
    }
}