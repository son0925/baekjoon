class Solution {
    public int solution(int[] wallet, int[] bill) {
        int result = 0;
        
        while (!isAble(wallet, bill)) {
            setSize(bill);
            result++;
        }
        
        return result;
    }
    
    // 지갑 사이즈에 맞는지
    public boolean isAble(int[] wallet, int[] bill) {
        return min(wallet) >= min(bill) && max(wallet) >= max(bill);
    }
    
    
    public int max(int[] arr) {
        if (arr[0] > arr[1])
            return arr[0];
        return arr[1];
    }
    public int min(int[] arr) {
        if (arr[0] < arr[1])
            return arr[0];
        return arr[1];
    }
    
    // 지폐 접기
    public void setSize(int[] bill) {
        if (bill[0] > bill[1]) {
            bill[0] /= 2;
        } else {
            bill[1] /= 2;
        }
    }
}