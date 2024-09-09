import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int result = 0;
        
        Arrays.sort(wallet);
        while (!isAble(wallet, bill)) {
            setSize(bill);
            result++;
        }
        
        return result;
    }
    
    // 지갑 사이즈에 맞는지
    public boolean isAble(int[] wallet, int[] bill) {
        // 오름차순으로 정렬
        Arrays.sort(bill);
        return wallet[0] >= bill[0] && wallet[1] >= bill[1];
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