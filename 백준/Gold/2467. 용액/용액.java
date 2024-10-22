import java.util.*;

class Main {
	public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        
    	int n = in.nextInt();
    	in.nextLine();
    	
    	List<String> list = new ArrayList<>(Arrays.asList(in.nextLine().split(" ")));
    	int[] solution = list.stream()
    			.mapToInt(Integer::parseInt)
    			.toArray()
    			;
    	
    	
    	int s = 0;
    	int e = solution.length - 1;
    	
    	int min = solution[s];
    	int max = solution[e];
    	int diff = Math.abs(min + max);
    	
    	while (s < e) {
    		
    		if (diff >= Math.abs(solution[s] + solution[e])) {
    			min = solution[s];
    			max = solution[e];
    			diff = Math.abs(solution[s] + solution[e]);
    		}
    		

    		if (Math.abs(solution[s]) > Math.abs(solution[e])) {
    			s++;
    		} else {
    			e--;
    		}
    	}
    	
    	System.out.println(min + " " + max);
    }
}