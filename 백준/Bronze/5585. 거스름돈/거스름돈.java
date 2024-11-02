import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	
    	Scanner in = new Scanner(System.in);
    	
    	int money = 1000 - in.nextInt();
    	
    	int count = 0;
    	while (money > 0) {
    		count += money / 500;
    		money %= 500;
    		
    		count += money / 100;
    		money %= 100;
    		
    		count += money / 50;
    		money %= 50;
    		
    		count += money / 10;
    		money %= 10;
    		
    		count += money / 5;
    		money %= 5;
    		
    		count += money / 1;
    		money %= 1;
    	}
    	
    	System.out.println(count);
    }

}