import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Queue<Integer>> map = new HashMap<>();
        int[] sortedArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            sortedArr[i] = n;

            if (map.containsKey(n)) {
                map.get(n).offer(i);
            } else {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                map.put(n, queue);
            }
        }

        Arrays.sort(sortedArr);


        int maxDiff = 0;
        for (int i = 0; i < N; i++) {
            int num = sortedArr[i];

            int idx = map.get(num).poll();
            maxDiff = Math.max(maxDiff, Math.min(Math.abs(idx - i), N-i));
        }

        System.out.println(maxDiff);
    }
}