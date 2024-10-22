import java.util.*;

class Main {
	
	static int r,c,t;
	static int[][] floor; // 현재 먼지 상태
	static int[][] spreadFloor; // 확산된 먼지 상태
	
	// 로봇의 위치
	static int robotR = -1;
	static int robotC = -1;
	
	
	// 확산 방향
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        
    	r = in.nextInt();
    	c = in.nextInt();
    	t = in.nextInt();
    	
    	in.nextLine();
    	
    	// 바닥 생성
    	initFloor(in);
    	
    	for (int i = 0; i < t; i++) {
    		// 먼지가 확산된다
        	spread();
        	
        	// 공기청정기 바람이 나온다
        	blowing();
    	}
    	
    	
    	System.out.println(getFineDust() + 2);
    }
	
	public static void blowing() {
		for (int i = robotR-1; i >= 0; i--) {
			// 먼지가 이동한 곳이 로봇 위치라면
			if (floor[i+1][0] == -1) {
				continue;
			}
			
			floor[i+1][0] = floor[i][0];
		}
		
		for (int i = 1; i < c; i++) {
			floor[0][i-1] = floor[0][i];
		}
		
		for (int i = 1; i <= robotR; i++) {
			floor[i-1][c-1] = floor[i][c-1];
		}
		
		for (int i = c-2; i >= 1; i--) {
			floor[robotR][i+1] = floor[robotR][i];
		}
		floor[robotR][1] = 0;
		
		robotR++;
		for (int i = robotR+1; i < r; i++) {
			if (floor[i-1][0] == -1) {
				continue;
			}
			
			floor[i-1][0] = floor[i][0];
		}
		
		for (int i = 1; i < c; i++) {
			floor[r-1][i-1] = floor[r-1][i];
		}
		
		
		for (int i = r-2; i >= robotR; i--) {
			floor[i+1][c-1] = floor[i][c-1];
		}
		
		for (int i = c-2; i >= 1; i--) {
			floor[robotR][i+1] = floor[robotR][i];
		}
		
		floor[robotR][1] = 0;
		
		robotR--;
	}
	
	// 먼지 확산
	public static void spread() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				
				// 먼지가 없거나 로봇일 때
				if (floor[i][j] <= 0) {
					continue;
				}
				
				// 확산된 횟수
				int count = spreadCount(i, j);
				floor[i][j] -= floor[i][j] / 5 * count;
			}
		}
		
		// 먼지 확산 writeBack 하기
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				floor[i][j] += spreadFloor[i][j]; // 확산된 먼지 넣기
				spreadFloor[i][j] = 0; // 초기화하기
			}
		}
	}
	
	// 확산 횟수 및 확산 배열에 저장하기
	public static int spreadCount(int i, int j) {
		int count = 0;
		for (int k = 0; k < 4; k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];
			
			// 크기를 벗어나지 않고 로봇에 가지 않게
			if (nr >= 0 && nc >= 0 && nr < r && nc < c && !((nr == robotR || nr == robotR + 1) && nc == robotC)) {
				count++;
				spreadFloor[nr][nc] += floor[i][j] / 5;
			}
		}
		
		return count;
	}
	
	// 바닥 생성하기
	public static void initFloor(Scanner in) {
		floor = new int[r][c]; // 현재 바닥 먼지 상태
		spreadFloor = new int[r][c]; // 확산된 먼지 상태 저장
    	
    	for (int i = 0; i < r; i++) {
    		String[] tmp = in.nextLine().split(" ");
    		
    		for (int j = 0; j < c; j++) {
    			int el = Integer.parseInt(tmp[j]);
    			if (el == -1 && robotR == -1) {
    				robotR = i;
    				robotC = j;
    			}
    			floor[i][j] = el;
    		}
    	}
	}
	
	public static int getFineDust() {
		int result = 0;
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result += floor[i][j];
			}
		}
		
		return result;
	}
	
	
	public static void print() {
		for (int[] arr : floor) {
			System.out.println(Arrays.toString(arr));
		}
		
		System.out.println("----------------");
		
		for (int[] arr : spreadFloor) {
			System.out.println(Arrays.toString(arr));
		}
	}
}