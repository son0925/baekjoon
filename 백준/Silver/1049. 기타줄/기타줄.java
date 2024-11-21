import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int m = in.nextInt();
        
        int price = 0;
        
        int pack = Integer.MAX_VALUE;
        int singleItem = Integer.MAX_VALUE;
        
        
        for (int i = 0; i < m; i++) {
        	pack = Math.min(pack, in.nextInt());
        	singleItem = Math.min(singleItem, in.nextInt());
        }
        
        if (pack < singleItem * 6) {
        	price = n / 6 * pack;
        	n %= 6;
        }
        
        if (n > 6) {
        	price += Math.min(singleItem * n, pack * n / 6);
        } else {
        	price += Math.min(singleItem * n, pack);
        }
        
        System.out.println(price);
    }
}
