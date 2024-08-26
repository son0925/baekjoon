import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // BufferedReader와 BufferedWriter를 사용해 입출력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        
        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);
        
       
        
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {
        	q.add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!q.isEmpty()) {
        	int num = q.poll();
        	count = (count + 1) % k;
        	
        	if (count == 0)
        		sb.append(num + ", ");
        	else
        		q.add(num);
        }
        sb.setLength(sb.length()-2);
        bw.write(sb.toString()+ ">");
        // BufferedWriter의 남은 데이터를 출력
        bw.flush();
        bw.close();
    }
}