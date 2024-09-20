import java.util.*;

class Main {
    public static void main(String[] args) {
        int result = 0;
        Scanner in = new Scanner(System.in);
        
        int n = Integer.parseInt(in.nextLine());
        
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        
        String[] inputArr1 = in.nextLine().split(" ");
        String[] inputArr2 = in.nextLine().split(" ");
        
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(inputArr1[i]);
            arr2[i] = Integer.parseInt(inputArr2[i]);
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        for (int i = 0; i < n; i++) {
            result += arr1[i] * arr2[n-i-1];
        }
        
        System.out.println(result);
    }
}