class Solution {
    public String solution(String polynomial) {
        String[] parts = polynomial.split(" ");
        
        int x = 0;
        int num = 0;
        for (String s : parts) {
            if (s.contains("x")) {
                s = s.replace("x", "");
                if (s.length() == 0)
                    x++;
                else
                    x += Integer.parseInt(s);
            } else if (!s.equals("+")) {
                num += Integer.parseInt(s);
            }
        }
        
        String result;
        
        if (x == 0 && num == 0) {
            return "0";
        }
        
        if (x == 1) {
            result = "x";
        } else {
            result = x + "x";
        }
        
        if (num == 0) {
            return result;
        } else if (x == 0) {
            return "" + num;
        } else {
            result += " + " + num;
        }
        
        return result;
    }
}