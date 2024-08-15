class Solution {
    public String[] solution(String my_str, int n) {
        int m = my_str.length() % n == 0 ? my_str.length() / n : my_str.length() / n + 1;
        String[] result = new String[m];
        
        int index = 0;
        for (int i = 0; i < my_str.length(); i+=n) {
            if (i + n < my_str.length())
                result[index++] = my_str.substring(i,i+n);
            else
                result[index++] = my_str.substring(i, my_str.length());
        }
        
        return result;
    }
}