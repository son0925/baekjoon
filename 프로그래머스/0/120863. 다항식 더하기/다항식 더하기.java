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
        
        if (x == 0 && num != 0) {
            return "" + num;
        } else if (x > 1 && num == 0) {
            return x + "x";
        } else if (x == 1 && num != 0) {
            return "x + " + num;
        } else if (x == 1 && num == 0) {
            return "x";
        }
        return x + "x + " + num;
    }
}