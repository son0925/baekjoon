import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // BufferedReader와 BufferedWriter를 사용해 입출력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        String[] arr = br.readLine().split(" ");
        
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        
        int result = 1;
        for (int i = 0; i < m; i++) {
        	result *= n--;
        }
        
        for (int i = 1; i <= m; i++) {
        	result /= i;
        }
        
        bw.write(result + "\n");
        
        // BufferedWriter의 남은 데이터를 출력
        bw.flush();
        bw.close();
    }
}