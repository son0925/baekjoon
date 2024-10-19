import java.util.*;

class Main {
	
	private static class Node {
		int no;
		int cost;
		
		Node(int no, int cost) {
			this.no = no;
			this.cost = cost;
		}
	}
	
	static int n;
	static List<Node>[] graph;
	static Scanner in;
	static int max = -1;
	static boolean[] visit;
	static int furthestNode;
	
    public static void main(String[] args) {
        in = new Scanner(System.in);
        
        n = in.nextInt();
        in.nextLine();
        
        // 그래프 생성
        initGraph();
        
        // 1번 노드에서 가장 먼 노드를 탐색
        visit = new boolean[n+1];
        dfs(1,0);
        
        // 가장 먼 노드에서 제일 먼 거리를 탐색
        visit = new boolean[n+1];
        max = -1;
        dfs(furthestNode, 0);
        
        System.out.println(max);
    }
    
    
    public static void dfs(int curNode, int sum) {
    	visit[curNode] = true;
    	
    	if (sum > max) {
    		max = sum;
    		furthestNode = curNode;
    	}
    	
    	for (Node node : graph[curNode]) {
    		if (!visit[node.no]) {
    			dfs(node.no, sum + node.cost);
    		}
    	}
	}


	public static void initGraph() {
    	graph = new ArrayList[n+1];
    	
    	for (int i = 1; i <=n; i++) {
    		graph[i] = new ArrayList<>();
    	}
    	
    	inputGraph();
    }
    
    public static void inputGraph() {
    	for (int i = 0; i < n-1; i++) {
    		String[] arr = in.nextLine().split(" ");
    		
    		int node1 = Integer.parseInt(arr[0]);
    		int node2 = Integer.parseInt(arr[1]);
    		int cost = Integer.parseInt(arr[2]);
    		
    		graph[node1].add(new Node(node2, cost));
    		graph[node2].add(new Node(node1, cost));
    	}
    }
}