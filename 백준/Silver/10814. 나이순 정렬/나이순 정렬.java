import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // BufferedReader와 BufferedWriter를 사용해 입출력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스의 수를 입력 받음
        int n = Integer.parseInt(br.readLine());
        
        int[] ageArr = new int[n];
        String[] nameArr = new String[n];
        
        for (int i = 0; i < n; i++) {
        	String[] userInfo = br.readLine().split(" ");
        	
        	String name = userInfo[1];
        	int age = Integer.parseInt(userInfo[0]);
        	
        	ageArr[i] = age;
        	nameArr[i] = name;
        }
        
        int[] sortedAgeArr = Arrays.copyOf(ageArr, n);
        Arrays.sort(sortedAgeArr);
        
        for (int i = 0; i < n; i++) {
        	int age = sortedAgeArr[i];
        	for (int j = 0; j < n; j++) {
        		if (age == ageArr[j]) {
        			ageArr[j] = -1;
        			bw.write(age + " " + nameArr[j] + "\n");
        			break;
        		}
        	}
        }
        // BufferedWriter의 남은 데이터를 출력
        bw.flush();
        bw.close();
    }
}