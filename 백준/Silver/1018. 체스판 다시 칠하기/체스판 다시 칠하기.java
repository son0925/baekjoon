import java.util.*;
import java.io.*;

public class Main {
	
	static String[] board;
	static int result = 65;
	
    public static void main(String[] args) throws IOException {
    	
    	Scanner in = new Scanner(System.in);
    	
    	int n = in.nextInt();
    	int m = in.nextInt();
    	
    	in.nextLine();
    	
    	board = new String[n];
    	for (int i = 0; i < n; i++) {
    		board[i] = in.nextLine();
    	}
    	
    	
    	for (int i = 0; i < n-7; i++) {
    		for (int j = 0; j < m-7; j++) {
    			// 시작 지점
    			counting(i, j);
    		}
    	}
    	
    	System.out.println(result);
    }
    
    public static void counting(int x, int y) {
    	char compareChar = board[x].charAt(y);
    	
    	int count = 0;
    	for (int i = x; i < x+8; i++) {
    		for (int j = y; j < y+8; j++) {
    			char curChar = board[i].charAt(j);
    			
    			if ((i+j) % 2 == 0 && curChar != compareChar) {
    				count++;
    			} else if ((i+j) % 2 == 1 && curChar == compareChar) {
    				count++;
    			}
    		}
    	}
    	
    	result = Math.min(result, Math.min(64-count, count));
    	
    }

}