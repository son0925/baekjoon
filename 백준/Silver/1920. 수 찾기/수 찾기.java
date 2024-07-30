import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        br.readLine();
        HashMap<String,Integer> map = new HashMap<>();
        
        for (String s : br.readLine().split(" ")) {
        	map.put(s, 1);
        }
        
        br.readLine();
        String[] arr = br.readLine().split(" ");
        
        for (int i = 0; i < arr.length; i++) {
        	bw.write(map.getOrDefault(arr[i], 0) + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}