
import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int M;
	static long maxSqrt = -1;
	static int[][] table;
	
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행 수
        M = Integer.parseInt(st.nextToken()); // 열 수

        table = new int[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine(); 
            for (int j = 0; j < M; j++) {
                table[i][j] = row.charAt(j) - '0'; 
            }
        }

        
        start();
        
        System.out.println(maxSqrt);
    }
    
    // 시작 지점
    public static void start() {
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < M; j++) {
        		isSqrt(new StringBuilder().append(table[i][j]));
        		// 기울기
        		equidistantSequence(i, j);
        	}
        }
    }
    
    public static void equidistantSequence(int x, int y) {
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < M; j++) {
    			if (i == 0 && j == 0) continue;
    			recursion(x, y, i, j, new StringBuilder());
    			recursion(x, y, i*-1, j, new StringBuilder());
    			recursion(x, y, i, j*-1, new StringBuilder());
    			recursion(x, y, i*-1, j*-1, new StringBuilder());
    		}
    	}
    }
    
    
    /**
     * 
     * @param x 현재 위치
     * @param y 현재 위치
     * @param dx 등차
     * @param dy 등차
     * @param sb 지나온 수 저장
     */
    public static void recursion(int x, int y, int dx, int dy, StringBuilder sb) {
    	if (x >= N || y >= M || x < 0 || y < 0) {
    		return;
    	}
    	
    	
    	sb.append(table[x][y]);
    	
    	isSqrt(sb);
    	
    	recursion(x+dx, y+dy, dx, dy, sb);
    }
    
    public static void isSqrt(StringBuilder sb) {
    	long num = Long.parseLong(sb.toString());
    	long sqrtNum = (long)Math.sqrt(num);
    	
    	
    	if (num == sqrtNum * sqrtNum) {
    		maxSqrt = Math.max(maxSqrt, num);
    	}
    	
    }
}