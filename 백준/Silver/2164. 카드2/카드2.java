import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // BufferedReader와 BufferedWriter를 사용해 입출력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {
        	q.add(i);
        }
        
        
        while(q.size() > 1) {
        	q.poll();
        	q.add(q.poll());
        }
        bw.write(q.poll() + "\n");
        // BufferedWriter의 남은 데이터를 출력
        bw.flush();
        bw.close();
    }
}