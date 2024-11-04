import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	
    	Scanner in = new Scanner(System.in);
    	
    	String[] arr = in.nextLine().split("");
    	
    	Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
    	
    	
    	System.out.println(String.join("", arr));
    }

}