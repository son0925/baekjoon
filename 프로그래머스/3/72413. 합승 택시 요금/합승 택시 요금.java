class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] routeNode = initRouterNode(fares, n);
        int index, fare, minFare = Integer.MAX_VALUE;
        boolean[] visited;
        
        
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            
            for (int j = 0; j < n; j++) {
                index = nextIndex(routeNode[i], n, visited);
                fare = routeNode[i][index];
                
                for (int k = 0; k < n; k++) {
                    if (routeNode[k][index] + fare < routeNode[i][k]) {
                        routeNode[i][k] = routeNode[k][index] + fare;
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            fare = routeNode[s-1][i] + routeNode[i][a-1] + routeNode[i][b-1];
            minFare = Math.min(fare, minFare);
        }
        return minFare;
    }
    
    public static int nextIndex(int[] nodeFareArr, int n, boolean[] visited) {
        int minIdx = 0;
        int minFare = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i] && nodeFareArr[i] < minFare) {
                minFare = nodeFareArr[i];
                minIdx = i;
            }
        }
        visited[minIdx] = true;
        return minIdx;
    }
    
    
    public static int[][] initRouterNode(int[][] fares, int n) {
        int[][] result = new int[n][n];
        
        for (int i = 0; i < fares.length; i++) {
            result[fares[i][0]-1][fares[i][1]-1] = fares[i][2];
            result[fares[i][1]-1][fares[i][0]-1] = fares[i][2];
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && result[i][j] == 0) {
                    result[i][j] = 2000000;
                }
            }
        }
        
        return result;
    }
}