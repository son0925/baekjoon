import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Main.solution();
        }

        System.out.println(sb);
    }

    public static void solution() throws IOException {
        Map<String,Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();
            String category = st.nextToken();

            map.put(category, map.getOrDefault(category, 0) + 1);
        }


        int result = 1;
        for (String key : map.keySet()) {
            result *= map.get(key) + 1;
        }

        sb.append(result-1).append("\n");
    }
}