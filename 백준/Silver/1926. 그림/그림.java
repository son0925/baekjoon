import java.util.*;
import java.io.*;


public class Main {
	
	static int n,m;
	static int[][] drawingPaper;
	static boolean[][] visited;
	static int size = 0;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	
	public static void main(String[] args) throws Exception{
		// 입력을 효율적으로 받기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 효율적으로 하기 위해 BufferedWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        List<Integer> result = new ArrayList<>();
        
        String[] area = br.readLine().split(" ");
        n = Integer.parseInt(area[0]);
        m = Integer.parseInt(area[1]);
        
        drawingPaper = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
        	String[] line = br.readLine().split(" ");
        	for (int j = 0; j < m; j++) {
        		drawingPaper[i][j] = Integer.parseInt(line[j]);
        	}
        }
        
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		size = 0;
        		if (drawingPaper[i][j] == 1 && !visited[i][j]) {
        			size = 0;
        			dfs(i, j);
        			result.add(size);
        		}
        	}
        }
        
        if (result.size() == 0) {
        	bw.write("0\n");
        	bw.write("0");
        } else {
        	Collections.sort(result);
        	bw.write(result.size() + "\n");
        	bw.write(result.get(result.size()-1) + "");
        }
        
        bw.flush();
        bw.close();
	}
	
	static void dfs(int x, int y) {
		size ++;
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && drawingPaper[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}
	}
}