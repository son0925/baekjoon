import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String[] input = in.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int cutLine = Integer.parseInt(input[1]);
        
        String[] strArr = in.nextLine().split(" ");
        int[] scores = new int[n];
        
        for (int i = 0; i < n; i++) {
        	scores[i] = Integer.parseInt(strArr[i]);
        }
        
        insectionSort(scores);
        
        System.out.println(scores[cutLine-1]);
    }

	public static void insectionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int target = arr[i];
			int j = i - 1;
			
			while (j >= 0 && arr[j] < target) {
				arr[j+1] = arr[j];
				j--;
			}
			
			arr[j+1] = target;
		}
	}
}