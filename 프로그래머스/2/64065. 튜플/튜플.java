import java.util.*;

class Solution {
    public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        
        String[] arr = s.substring(2,s.length()-2).split("\\},\\{");
        int[] result = new int[arr.length];
        Arrays.sort(arr, (o1, o2) -> {return o1.length() - o2.length();});
        
        int index = 0;
        for (String str1 : arr) {
            for (String str2 : str1.split(",")) {
                if (set.add(str2))
                    result[index++] = Integer.parseInt(str2);
            }
        }
        return result;
    }
}