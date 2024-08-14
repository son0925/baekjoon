import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        bw.write(pibo(n) + "\n");
        
        bw.flush();
        bw.close();
    }
	
	static int pibo(int n) {
		if (n == 1) {
			return 1;
		} else if (n == 0) {
			return 0;
		}
		
		return pibo(n-1) + pibo(n-2);
	}
}