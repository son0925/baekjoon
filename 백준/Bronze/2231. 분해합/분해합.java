import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // BufferedReader와 BufferedWriter를 사용해 입출력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        int n = Integer.parseInt(br.readLine());
        
        bw.write(getDecompositionSum(n) + "\n");
        // BufferedWriter의 남은 데이터를 출력
        bw.flush();
        bw.close();
    }
    
    public static int getDecompositionSum(int n) {
    	int sum = 0;
    	for (int i = 1; i < n; i++) {
    		sum = i;
    		int j = i;
    		while (j > 0) {
    			sum += j % 10;
    			j /= 10;
    		}
    		if (n == sum) return i;
    	}
    	
    	return 0;
    }
}