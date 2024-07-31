import java.util.*;
import java.io.*;

/**
 * 1. 로직
 *  - 값 받고 설정하기 :
 *    (1) "x y" 를 받는다
 *    (2) 도화지의 크기 설정
 *    (3) 방문 유무 배열 생성
 *    (4) 2중 for문으로 도화지 채우기
 *  - 2중 for문으로 1인지 확인하고 방문하지 않았다면 bfs 실행
 *  - bfs 로직 :
 *    (1) 방문 유무를 방문한 것으로 바꾸기
 *    (2) queue에 x,y 넣기
 *    (3) queue가 비어질 때 까지 반복문 작성 while문
 *    (4) x, y 값 변경하면서 조건에 맞는지 확인하기
 *    		- 조건 : 0 <= nowX < n && 0 <= nowY < m (도화지 크기를 넘어가지 않는가), 방문을 했는가, 해당 좌표의 요소가 1인가
 *    (5) 조건에 맞다면 queue에 값을 넣고 또 다시 반복한다
 *  - bfs가 종료되면 List에 count했는 값을 집어넣는다
 *  - 이 list는 size는 그림의 수, 정렬을 하여 최댓값은 그림의 최대 크기를 구할 수 있다.
 * 2. 시간복잡도
 * 	- BFS : O(V+E)
 * 3. 자료구조
 *  - Queue
 */
public class Main {
	// 도화지 크기 n, m
	// 2차원 배열을 생성하고 도화지 크기를 넘지 않는지 확인하는 변수
	static int n, m;
	
	// 도화지, 방문 유무
	static int[][] drawingPaper;
	static boolean[][] visited;
	
	// 그림의 크기
	static int size;
	
	// 좌표 이동 변수
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		// 입력을 효율적으로 받기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 효율적으로 하기 위해 BufferedWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // list.size()는 그림의 수, 해당 리스트의 최댓값은 그림의 최대 크기
        List<Integer> result = new ArrayList<>();
        
        String[] area = br.readLine().split(" ");
        n = Integer.parseInt(area[0]);
        m = Integer.parseInt(area[1]);
        
        // 도화지, 방문 유무 배열 크기 설정
        drawingPaper = new int[n][m];
        visited = new boolean[n][m];
        
        // 도화지 채우는 2중 for문
        for (int i = 0; i < n; i++) {
        	String[] line = br.readLine().split(" ");
        	for (int j = 0; j < m; j++) {
        		drawingPaper[i][j] = Integer.parseInt(line[j]);
        	}
        }
        
        // Main 로직
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		size = 0;
        		if (drawingPaper[i][j] == 1 && !visited[i][j]) {
        			size = 1;
        			bfs(i,j);
        			result.add(size);
        		}
        	}
        }
        
        if (result.size() == 0) {
        	bw.write(0 + "\n");
        	bw.write(0 + "\n");
        } else {
        	Collections.sort(result);
            bw.write(result.size() + "\n");
            bw.write(result.get(result.size()-1) + "\n");
        }
        
        bw.flush();
        bw.close();
	}
	
	static void bfs(int x, int y) {
		visited[x][y] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int[] indexArr = queue.poll();
			// 현재 큐에서 추출한 x, y 좌표
			int nowX = indexArr[0];
			int nowY = indexArr[1];
			
			// 상하좌우 이동하여 조건에 맞으면 queue에 넣기
			for (int i = 0; i < 4; i++) {
				int nx = nowX + dx[i];
				int ny = nowY + dy[i];
				
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && drawingPaper[nx][ny] == 1) {
					// 그림 사이즈 + 1, 방문 표시, 스택에 추가하여 해당 좌표의 상하좌우 확인
					size++;
					visited[nx][ny] = true;
					queue.add(new int[] {nx,ny});
				}
			}
		}
	}
}