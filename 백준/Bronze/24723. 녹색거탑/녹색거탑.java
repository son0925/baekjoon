import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // BufferedReader와 BufferedWriter를 사용해 입출력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        int n = Integer.parseInt(br.readLine());
        
        if (n == 1) {
        	bw.write("2\n");
        } else {
        	bw.write((int)Math.pow(2, n)+"\n");
        }
        
        // BufferedWriter의 남은 데이터를 출력
        bw.flush();
        bw.close();
    }
}