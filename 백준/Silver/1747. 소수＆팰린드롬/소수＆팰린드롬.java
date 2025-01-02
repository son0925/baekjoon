import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while (true) {

            if (isPrime(n) && isPalindrome(n)) {
                System.out.println(n);
                return;
            }

            n++;
        }
    }

    public static boolean isPalindrome(int n) {
        String s = "" + n;

        int l = 0;
        int r = s.length() - 1;

        while (l <= r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPrime(int n) {
        
        if (n == 1) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}