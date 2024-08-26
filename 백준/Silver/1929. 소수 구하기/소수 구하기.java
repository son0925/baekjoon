import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // BufferedReader와 BufferedWriter를 사용해 입출력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        
        String[] arr = br.readLine().split(" ");
        
        int s = Integer.parseInt(arr[0]);
        int e = Integer.parseInt(arr[1]);
        
        
        for (int i = s; i <= e; i++) {
        	boolean isAble = true;
        	if (i == 1) continue;
        	for (int j = 2; j < (int) Math.sqrt(i)+1; j++) {
        		if (i % j == 0) {
        			isAble = false;
        			break;
        		}
        	}
        	if (isAble) {
        		bw.write(i + "\n");
        	}
        }
        // BufferedWriter의 남은 데이터를 출력
        bw.flush();
        bw.close();
    }
}