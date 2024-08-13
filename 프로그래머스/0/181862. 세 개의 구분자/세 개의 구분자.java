class Solution {
    public String[] solution(String myStr) {
        String[] result = myStr.replaceAll("[abc]+", " ").trim().split(" ");
        
        if (result[0].isEmpty())
            return new String[]{"EMPTY"};
        return result;
    }
}