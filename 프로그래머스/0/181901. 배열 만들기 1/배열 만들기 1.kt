class Solution {
    fun solution(n: Int, k: Int): IntArray {
        // IntArray(n / k): n을 k로 나눈 크기의 배열 생성
        // { i -> (i + 1) * k }: i는 0부터 시작해서 배열 크기 - 1까지 증가하며, 각 인덱스에 (i + 1) * k 값을 할당
        // 즉, k의 배수를 배열에 차례대로 추가
        var result = IntArray(n / k) { i -> (i + 1) * k }
        
        return result
    }
}
