import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int n = emergency.length;
        int[] result = new int[n];
        
        List<Integer> list = new ArrayList<>();
        for (int num : emergency) {
            list.add(num);
        }
        
        int[] copySortedArr = Arrays.copyOf(emergency, n);
        Arrays.sort(copySortedArr);
        int count = 1;
        for (int i = n-1; i >= 0; i--) {
            // 우선순위가 가장 높은 요소
            int target = copySortedArr[i];
            result[list.indexOf(target)] = count++;
        }
        
        return result;
    }
}