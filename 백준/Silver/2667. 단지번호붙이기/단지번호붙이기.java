import java.util.*;

class Main {
	
	static int n;
	static int[][] graph;
	static int count = 0;
	static boolean[][] visit;
	
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        
    	
    	List<Integer> list = new ArrayList<>();
    	n = in.nextInt();
    	in.nextLine();
    	
    	initGraph(in);
    	
//    	viewGraph();
    	
    	visit = new boolean[n][n];
    	
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++) {
    			if (!visit[i][j] && graph[i][j] == 1) {
    				dfs(i, j);
    				list.add(count);
    				count = 0;
    			}
    		}
    	}
    	
    	System.out.println(list.size());
    	Collections.sort(list);
    	for (int num : list) {
    		System.out.println(num);
    	}
	}
	
	public static void dfs(int x, int y) {
		visit[x][y] = true;
		count++;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visit[nx][ny] && graph[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}
	}
	
	public static void initGraph(Scanner in) {
		graph = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String[] s = in.nextLine().split("");
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(s[j]);
			}
		}
	}
	
	public static void viewGraph() {
		for (int[] arr : graph) {
			System.out.println(Arrays.toString(arr));
		}
	}
}