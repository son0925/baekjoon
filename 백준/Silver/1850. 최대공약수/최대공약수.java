import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    String[] arr = br.readLine().split(" ");
	    
	    long n = Long.parseLong(arr[0]);
	    long m = Long.parseLong(arr[1]);
	    
	    while (m != 0) {
	    	long tmp = n % m;
	    	n = m;
	    	m = tmp;
	    }
	    while(n-- > 0) {
	        bw.write("1");
        }
	    
	    bw.flush();
	    bw.close();
	}
}
