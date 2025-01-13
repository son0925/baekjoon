import java.util.*;
import java.io.*;

public class Main {
    static String[] converter = new String[4000]; // DP 배열
    static Map<Character, Integer> romanToIntMap = new HashMap<>(); // 로마 숫자 -> 숫자 매핑
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{

        initMap();

        initConverter();

        int num1 = romanToInt(br.readLine());
        int num2 = romanToInt(br.readLine());

        int sum = num1 + num2;
        String roman = converter[sum];

        System.out.println(sum);
        System.out.println(roman);
    }

    public static void initMap() {
        romanToIntMap.put('I',1);
        romanToIntMap.put('V',5);
        romanToIntMap.put('X',10);
        romanToIntMap.put('L',50);
        romanToIntMap.put('C',100);
        romanToIntMap.put('D',500);
        romanToIntMap.put('M', 1000);
    }


    public static void initConverter() {
        for (int i = 1; i < 4000; i++) {
            converter[i] = intToRoman(i);
        }
    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }

        return sb.toString();
    }

    public static int romanToInt(String roman) {
        int result = 0;
        for (int i = 0; i < roman.length()-1; i++) {
            int cur = romanToIntMap.get(roman.charAt(i));
            if (cur < romanToIntMap.get(roman.charAt(i+1))) {
                result -= cur;
            } else {
                result += cur;
            }
        }

        return result + romanToIntMap.get(roman.charAt(roman.length() - 1));
    }
}