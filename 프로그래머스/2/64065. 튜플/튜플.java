import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Integer> uniqueNumbers = new ArrayList<>();
        String[] groups = s.substring(2, s.length() - 2).split("\\},\\{");
        List<String[]> parsedGroups = new ArrayList<>();
        
        for (String group : groups) {
            parsedGroups.add(group.split(","));
        }
        
        Collections.sort(parsedGroups, new Comparator<String[]>() {
            public int compare(String[] group1, String[] group2) {
                return Integer.compare(group1.length, group2.length);
            }
        });
        
        for (String[] group : parsedGroups) {
            for (String numStr : group) {
                int number = Integer.parseInt(numStr);
                
                if (!uniqueNumbers.contains(number)) {
                    uniqueNumbers.add(number);
                }
            }
        }
        
        int[] result = new int[uniqueNumbers.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = uniqueNumbers.get(i);
        }
        
        return result;
    }
}
