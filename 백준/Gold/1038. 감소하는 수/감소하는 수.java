import java.util.*;

public class Main {
    
	static List<Long> list;
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        list = new ArrayList<>();
        
        int n = in.nextInt();
        if (n > 1022) {
        	System.out.println(-1);
        	return;
        } else if (n <= 10) {
        	System.out.println(n);
        	return;
        }
        
        for (int i = 0; i < 10; i++) {
        	bp(i, 1);
        }
        Collections.sort(list);
        System.out.println(list.get(n));
    }
	
	public static void bp(long num, int idx) {
		if (idx > 10) return;
		
		list.add(num);
		for (int i = 0; i < num % 10; i++) {
			bp((num * 10) + i, idx + 1);
		}
	}
}