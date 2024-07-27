import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int count = Integer.parseInt(in.nextLine());
		
		for (int i = 0; i < count; i++) {
			int n = Integer.parseInt(in.nextLine());
			int zero = zeroCountPibo(1, 0, n);
			int one = oneCountPibo(0, 1, n);
			System.out.println(zero + " " + one);
		}
	}
	
	public static int zeroCountPibo(int lastNum, int num, int n) {
		if (n == 0) {
			return lastNum;
		}
		
		else if (n == 1) {
			return num;
		}
		
		return zeroCountPibo(num, lastNum+num, n-1);
	}
	public static int oneCountPibo(int lastNum, int num, int n) {
		if (n == 0) {
			return lastNum;
		}
		else if (n == 1) {
			return num;
		}
		
		return oneCountPibo(num, lastNum+num, n-1);
	}
}
