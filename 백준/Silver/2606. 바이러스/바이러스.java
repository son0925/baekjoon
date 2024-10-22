import java.util.*;

class Main {
	
	static List<Integer>[] graph;
	static int count = 0;
	static boolean[] visit;
	
	public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        
    	int n = in.nextInt();
    	in.nextLine();
    	
    	int link = in.nextInt();
    	in.nextLine();
    	
    	graph = new ArrayList[n+1];
    	visit = new boolean[n+1];
    	
    	for (int i = 0; i <= n; i++) {
    		graph[i] = new ArrayList<>();
    	}
    	
    	
    	for (int i = 0; i < link; i++) {
    		String[] tmp = in.nextLine().split(" ");
    		
    		int node1 = Integer.parseInt(tmp[0]);
    		int node2 = Integer.parseInt(tmp[1]);
    		
    		graph[node1].add(node2);
    		graph[node2].add(node1);
    	}
    	visit[1] = true;
    	dfs(1);
    	
    	System.out.println(count);
    }
	
	
	public static void dfs(int curNode) {
		
		for (int i = 0; i < graph[curNode].size(); i++) {
			int nextNode = graph[curNode].get(i);
			
			if (!visit[nextNode]) {
				visit[nextNode] = true;
				dfs(nextNode);
				count++;
			}
		}
		
	}
}