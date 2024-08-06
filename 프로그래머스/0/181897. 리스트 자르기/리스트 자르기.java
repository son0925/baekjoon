import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        
        List<Integer> list = new ArrayList<>();
        switch (n) {
            case 1:
                a = 0;
                c = 1;
                break;
            case 2:
                b = num_list.length-1;
                c = 1;
                break;
            case 3:
                c = 1;
                break;
        }
        
        for (int i = a; i <= b; i+=c) {
            list.add(num_list[i]);
        }
        
        int[] result = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}