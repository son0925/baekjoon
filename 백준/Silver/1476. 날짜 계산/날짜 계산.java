import java.util.*;
import java.io.*;

public class Main {
	
	static boolean[] prime = new boolean[10001];
	
    public static void main(String[] args) throws IOException {
    	
    	Scanner in = new Scanner(System.in);
    	
    	int E = in.nextInt();
    	int S = in.nextInt();
    	int M = in.nextInt();
    	
    	
    	int e = 1, s = 1, m = 1;
    	int year = 1;
    	
    	while (E != e || S != s || M != m) {
    		e++;
    		s++;
    		m++;
    		year++;
    		
    		if (e > 15) e = 1;
    		if (s > 28) s = 1;
    		if (m > 19) m = 1;
    	}
    	
    	System.out.println(year);
    }

}