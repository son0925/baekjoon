import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // BufferedReader와 BufferedWriter를 사용해 입출력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        
        String[] arr1 = br.readLine().split(" ");
        String[] arr2 = br.readLine().split(" ");
    	
        // 1 분자 : 2 분모
    	int a1 = Integer.parseInt(arr1[0]);
    	int a2 = Integer.parseInt(arr1[1]);
    	int b1 = Integer.parseInt(arr2[0]);
    	int b2 = Integer.parseInt(arr2[1]);
    	
    	int n = a1 * b2 + a2 * b1;
    	int m = a2 * b2;
    	
    	int gcd = gcd(n,m);
        
    	bw.write(n / gcd + " " + m / gcd);
        // BufferedWriter의 남은 데이터를 출력
        bw.flush();
        bw.close();
    }
    
    public static int gcd(int a, int b) {
    	if (b == 0) {
    		return a;
    	}
    	return gcd(b, a%b);
    }
    
    public static int lcm(int a, int b) {
    	return a * b / gcd(a,b);
    }
}