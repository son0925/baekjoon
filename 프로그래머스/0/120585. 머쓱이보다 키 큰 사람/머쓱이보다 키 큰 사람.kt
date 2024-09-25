class Solution {
    fun solution(array: IntArray, height: Int): Int {
        // return array.count{it > height}
        return array.filter{it > height}.size
    }
}