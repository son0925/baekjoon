import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// BufferedReader와 BufferedWriter를 사용해 입출력 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
        	String[] arr = br.readLine().split(" ");
        	
        	int x1 = Integer.parseInt(arr[0]);
        	int y1 = Integer.parseInt(arr[1]);
        	int r1 = Integer.parseInt(arr[2]);
        	
        	int x2 = Integer.parseInt(arr[3]);
        	int y2 = Integer.parseInt(arr[4]);
        	int r2 = Integer.parseInt(arr[5]);
        	
        	// 두 원의 중심점 거리 distance
        	double d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

        	// 두 원의 중심이 같을 때
        	if (x1 == x2 && y1 == y2) {
        		// 두 원의 크기가 같은 때(무한대의 경우의 수)
        		if (r1 == r2) {
        			bw.write("-1\n");
        		} 
        		// 동심원일 때(중심은 같은 위치지만 크기가 다를 때
        		else {
        			bw.write("0\n");
        		}
        	}
        	
        	// 두 원의 중심이 다를 때
        	else {
        		// 원이 서로 겹치지 않을 때
        		if (r1 + r2 < d || (r1 - r2) * (r1 - r2) > d * d) {
        			bw.write("0\n");
        		} else if (r1 + r2 == d || (r1 - r2) * (r1 - r2) == d * d) {
        			bw.write("1\n");
        		} else {
        			bw.write("2\n");
        		}
        	}
        }
        
        // BufferedWriter의 남은 데이터를 출력
        bw.flush();
        bw.close();
    }
}