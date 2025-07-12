import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int yongCost = 0;
        int minCost = 0;

        for (int i = 0; i < n; i++) {
            yongCost += (arr[i] / 30 + 1) * 10;
            minCost += (arr[i] / 60 + 1) * 15;
        }

        if (yongCost == minCost) {
            System.out.println("Y M " + yongCost);
        } else if (yongCost > minCost) {
            System.out.println("M " + minCost);
        } else {
            System.out.println("Y " + yongCost);
        }
    }
}