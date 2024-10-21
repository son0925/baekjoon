import java.util.*;

class Main {
	
	static int[][] graph;
	static StringBuilder dfsResult = new StringBuilder();
	static StringBuilder bfsResult = new StringBuilder();
	
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        
        int node = in.nextInt();
        int link = in.nextInt();
        int curNode = in.nextInt();
        
        in.nextLine();
        
        graph = new int[node+1][node+1];
        
        for (int i = 0; i < link; i++) {
        	String[] arr = in.nextLine().split(" ");
        	
        	int p1 = Integer.parseInt(arr[0]);
        	int p2 = Integer.parseInt(arr[1]);
        	
        	graph[p1][p2] = 1;
        	graph[p2][p1] = 1;
        }
        boolean[] visit = new boolean[graph.length];
        dfs(visit, curNode);
        
        bfs(curNode);
        
        System.out.println(dfsResult.toString().trim());
        System.out.println(bfsResult.toString().trim());
    }
    
    public static void bfs(int curNode) {
    	boolean[] visit = new boolean[graph.length];
    	visit[curNode] = true;
    	
    	Queue<Integer> q = new LinkedList<>();
    	q.add(curNode);
    	
    	while(!q.isEmpty()) {
    		int node = q.poll();
			bfsResult.append(node + " ");
    		
    		for (int i = 1; i < graph.length; i++) {
    			if (!visit[i] && graph[node][i] == 1) {
    				q.add(i);
    				visit[i] = true;
    			}
    		}
    	}
    }
    
    public static void dfs(boolean[] visit, int curNode) {
		dfsResult.append(curNode + " ");
    	visit[curNode] = true;
    	
    	for (int i = 1; i < graph.length; i++) {
    		if (!visit[i] && graph[curNode][i] == 1) {
    			dfs(visit, i);
    		}
    	}
    }
}