import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	
	static HashMap<Integer,Integer> map = new HashMap<>();
	
    public static void main(String[] args) throws IOException {
        
        Scanner in = new Scanner(System.in);
        
        N = in.nextInt();
        
        int addNum = 1;
        int result = 0;
        
        for (int i = 1; i <= N; i+=addNum) {
        	
        	result++;
        	addNum += 2;
        }
        
        System.out.println(result);
    }
}