import java.util.*;

class Solution {
    public long solution(String numbers) {
        String[] numArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        StringBuilder result = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (String s : numArr) {
            list.add(s);
        }
        
        
        StringBuilder sb = new StringBuilder();
        for (char c : numbers.toCharArray()) {
            sb.append(c);
            int idx = list.indexOf(sb.toString());
            if (idx >= 0) {
                result.append(idx);
                sb.setLength(0);
            }
        }
        
        return Long.parseLong(result.toString());
    }
}