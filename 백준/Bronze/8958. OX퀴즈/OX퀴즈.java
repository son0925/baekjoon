import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
        	String ox = br.readLine();
        	int sum = 0;
        	int consecutive = 0;
        	
        	for (char c : ox.toCharArray()) {
        		if (c == 'O') {
        			consecutive++;
        			sum += consecutive;
        		} else {
        			consecutive = 0;
        		}
        	}
        	bw.write(sum+"\n");
        	sum = 0;
        	
        }
        
        bw.flush();
        bw.close();
    }
}