import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        int n = Integer.parseInt(br.readLine());
        
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
        	String[] commond = br.readLine().split(" ");
        	
        	if (commond[0].equals("push")) {
        		stack.push(commond[1]);
        	}
        	else if (!stack.isEmpty() && commond[0].equals("top")) {
        		bw.write(stack.peek() + "\n");
        	}
        	else if (commond[0].equals("size")) {
        		bw.write(stack.size() + "\n");
        	}
        	else if (commond[0].equals("empty")) {
        		if (stack.isEmpty()) {
        			bw.write("1\n");
        		} else {
        			bw.write("0\n");
        		}
        	}
        	else if (!stack.isEmpty() && commond[0].equals("pop")) {
        		bw.write(stack.pop() + "\n");
        	}
        	else {
        		bw.write("-1\n");
        	}
        }
        
        bw.flush();
        bw.close();
    }
}