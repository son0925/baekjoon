class Solution {
    public int solution(int n) {
        int[] arr = {1,1};
        while (n > 1) {
            n--;
            int tmp = (arr[0] + arr[1]) % 1000000007;
            arr[0] = arr[1];
            arr[1] = tmp;
        }
        
        return arr[1];
    }
}