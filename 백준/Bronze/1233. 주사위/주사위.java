import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for (int i = 1; i <= a; i++) {
        	for (int j = 1; j <= b; j++) {
        		for (int k = 1; k <= c; k++) {
        			int sum = i + j + k;
        			map.put(sum, map.getOrDefault(sum, 0) + 1);
        		}
        	}
        }
        
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        
        int max = -1;
        int num = -1;
        for (int i = 0; i < keySet.size(); i++) {
        	int count = map.get(keySet.get(i));
        	
        	if (max < count) {
        		max = count;
        		num = keySet.get(i);
        	} 
        	else if (max == count) {
        		num = Math.min(num, keySet.get(i));
        	}
        }
        
        System.out.println(num);
    }
}