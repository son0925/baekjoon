class Solution {

    public String solution(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder();
        String[] arr = my_string.split("");

        // 주어진 인덱스 위치의 문자를 빈 문자열로 변경
        for (int i = 0; i < indices.length; i++) {
            arr[indices[i]] = "";
        }

        // 배열에서 빈 문자열이 아닌 문자를 결합하여 결과 문자열 생성
        for (String x : arr) {
            sb.append(x);
        }
        return sb.toString();
    }
}