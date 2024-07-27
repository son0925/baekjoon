import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int len = Integer.parseInt(in.nextLine());
		
		// 피보나치 배열 생성
		int[] piboArr = new int[41];
		piboArr[0] = 0;
		piboArr[1] = 1;
		for (int i = 2; i <= 40; i++) {
			piboArr[i] = piboArr[i-1] + piboArr[i-2];
		}
		
		
		for (int i = 0; i < len; i++) {
			int n = Integer.parseInt(in.nextLine());
			
			if (n == 0) {
				System.out.println(piboArr[1] + " " + piboArr[0]);
				continue;
			}
			else if (n == 1) {
				System.out.println(piboArr[0] + " " + piboArr[1]);
				continue;
			}
			System.out.println(piboArr[n-1] + " " + piboArr[n]);
		}
	}
	
	
}
