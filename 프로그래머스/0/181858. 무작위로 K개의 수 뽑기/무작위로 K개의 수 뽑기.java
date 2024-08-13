import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] result = new int[k];
        List<Integer> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!list.contains(arr[i]) && index < k) {
                result[index++] = arr[i];
                list.add(arr[i]);
            }
        }
        for (int i = index; i < k; i++) {
            result[i] = -1;
        }
        return result;
    }
}