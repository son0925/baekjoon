import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // BufferedReader와 BufferedWriter를 사용해 입출력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스의 수를 입력 받음
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
        	set.add(br.readLine());
        }

        List<String> list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<String>() {
        	@Override
        	public int compare(String s1, String s2) {
        		int lengthCompare = Integer.compare(s1.length(), s2.length());
        		if (lengthCompare != 0) {
        			return lengthCompare;
        		}
        		return s1.compareTo(s2);
        	}
        });
        
        for (String s : list) {
        	bw.write(s+"\n");
        }
        
        // BufferedWriter의 남은 데이터를 출력
        bw.flush();
        bw.close();
    }
}