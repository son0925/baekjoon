import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int result = Integer.MAX_VALUE;
        
        int[] board = new int[101];
        
        int x = in.nextInt();
        int y = in.nextInt();
        in.nextLine();
        
        for (int i = 0; i < x+y; i++) {
        	int s = in.nextInt();
        	int e = in.nextInt();
        	board[s] = e;
        	in.nextLine();
        }
        
        for (int i = 0; i < 101; i++) {
        	if (board[i] == 0) {
        		board[i] = i;
        	}
        }
        
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.add(new int[] {1,0});
        
        while(!q.isEmpty()) {
        	int[] arr = q.poll();
        	int pos = arr[0];
        	int count = arr[1];
        	
        	if (pos == 100) {
        		result = Math.min(arr[1], result);
        		continue;
        	}
        	
        	for (int i = 6; i >= 1; i--) {
        		if (pos + i <= 100 && !set.contains(pos+i)) {
        			set.add(pos+i);
        			q.add(new int[] {board[pos+i],count+1});
        		}
        	}
        }
        
        System.out.println(result);
    }
}