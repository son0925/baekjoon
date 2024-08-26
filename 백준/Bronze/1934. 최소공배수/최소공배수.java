import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // BufferedReader와 BufferedWriter를 사용해 입출력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
        	String[] arr = br.readLine().split(" ");
        	
        	int a = Integer.parseInt(arr[0]);
        	int b = Integer.parseInt(arr[1]);
        	
        	bw.write(lcm(a,b) + "\n");
        }
       
        
        
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