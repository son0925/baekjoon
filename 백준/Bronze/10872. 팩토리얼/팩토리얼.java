import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        int n = Integer.parseInt(br.readLine());
        
        int result = factorial(n);
        bw.write(result + "\n");
        
        bw.flush();
        bw.close();
    }
	
	static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		
		return n * factorial(n-1);
		
	}
}