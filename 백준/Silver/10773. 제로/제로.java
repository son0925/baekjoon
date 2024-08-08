import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws Exception{
		// 입력을 효율적으로 받기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 효율적으로 하기 위해 BufferedWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Stack<Integer> stack = new Stack<>();
        
        int n = Integer.valueOf(br.readLine());
        
        for (int i = 0; i < n; i++) {
        	int input = Integer.parseInt(br.readLine());
        	if (input == 0) {
        		stack.pop();
        	} else {
        		stack.push(input);
        	}
        }
        int result = 0;
        while(!stack.isEmpty()) {
        	result += stack.pop();
        }
        bw.write(result+"\n");
        bw.flush();
        bw.close();
	}
}