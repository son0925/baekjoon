import java.util.*;

class Main {
	
	static int s,e;
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        int count = in.nextInt();
        
        while (count <= 100) {
        	// 중앙값 구하기
        	int middle = num / count;
        	
        	// count 짝수일 때 홀수일 때
    		// 짝수 : 중앙 왼쪽
    		// 홀수 : 중앙
    		int sum = 0;

    		int start = middle - count / 2;
        	if (count % 2 == 0) {
        		start++;
        		for (int i = start; i < start+count; i++) {
        			sum += i;
        		}
        		
        		
        	} else {
        		for (int i = start; i < start+count; i++) {
        			sum += i;
        		}
        	}
        	
    		if (sum == num) {
    			printArr(start, count);
    			return;
    		} else {
    			count++;
    		}
        }
        
        System.out.println(-1);
    }
    
    public static void printArr(int start, int count) {
    	if (start < 0) {
    		System.out.println(-1);
    		return;
    	}
    	
    	String msg = "";
    	for (int i = start; i < start + count; i++) {
    		msg += i + " ";
    	}
    	
    	msg = msg.trim();
    	System.out.println(msg);
    }
}
