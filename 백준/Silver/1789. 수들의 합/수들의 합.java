import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	
    	Scanner in = new Scanner(System.in);
    	
    	long N = in.nextLong();
    	
    	long sum = 0;
    	int curNum = 1;
    	
    	while (true) {
    		sum += curNum++;
    		
    		if (sum == N) {
    			curNum--;
    			break;
    		} else if (sum > N) {
    			curNum -= 2;
    			break;
    		}
    	}
    	
    	System.out.println(curNum);
    }

}