import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	
	static HashMap<Integer,Integer> map = new HashMap<>();
	
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Scanner in = new Scanner(System.in);
        
        N = in.nextInt();
        
        for (int i = 0; i < N; i++) {
        	map.put(in.nextInt(), 1);
        }
        
        
        N = in.nextInt();
        for (int i = 0; i < N; i++) {
        	sb.append(map.getOrDefault(in.nextInt(), 0)).append(" ");
        }
        
        System.out.println(sb.toString().trim());
    }
}