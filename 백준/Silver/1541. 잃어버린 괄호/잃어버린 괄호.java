import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	
    	Scanner in = new Scanner(System.in);
    	
    	String s = in.nextLine();
    	
    	String[] arr= s.split("-");
    	
    	int result = evaluate(arr[0]);
    	
    	for (int i = 1; i < arr.length; i++) {
    		result -= evaluate(arr[i]);
    	}
    	
    	System.out.println(result);
    }
    
    public static int evaluate(String expr) {
    	String[] arr = expr.split("\\+");
    	
    	int result = 0;
    	
    	for (String s : arr) {
    		result += Integer.parseInt(s);
    	}
    	
    	return result;
    }

}