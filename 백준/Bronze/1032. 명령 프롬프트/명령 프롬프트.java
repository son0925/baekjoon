import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        
        in.nextLine();
        
        StringBuilder sb = new StringBuilder(in.nextLine());
        for (int i = 1; i < n; i++) {
        	String s = in.nextLine();
        	
        	for (int j = 0; j < s.length(); j++) {
        		if (sb.charAt(j) != s.charAt(j)) {
        			sb.setCharAt(j, '?');
        		}
        	}
        }
        System.out.print(sb);
    }
}