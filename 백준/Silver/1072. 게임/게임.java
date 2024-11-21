import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        
        int x = in.nextInt();
        int y = in.nextInt();
        int z = getPercent(x, y);
        
        int result = -1;
        int left = 0;
        int right = (int) 1e9;
        
        while (left <= right) {
        	int mid = (left + right) / 2;
        	
        	if (getPercent(x + mid, y+mid) != z) {
        		result = mid;
        		right = mid-1;
        	} else {
        		left = mid+1;
        	}
        }
        
        System.out.println(result);
    }
    
    private static int getPercent(int x, int y) {
    	return (int) ((long) y * 100 / x);
    }
}
