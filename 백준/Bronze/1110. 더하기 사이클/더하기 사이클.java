import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;
        
        int n = Integer.parseInt(br.readLine());
        int target = n;
        do {
        	int sum = n / 10 + n % 10;
        	n = n % 10 * 10 + sum % 10;
        	result++;
        }while(n != target);
        
        bw.write(result + "\n");
        
        bw.flush();
        bw.close();
    }
}