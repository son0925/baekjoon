import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        
        long[] arr = new long[2];
        arr[1] = 1;
        
        for (int i = 2; i <= N; i++) {
        	long tmp = arr[0];
        	arr[0] = arr[1];
        	arr[1] += tmp;
        }
        
        System.out.println(arr[1]);
    }
}