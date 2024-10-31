import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> character = new HashMap<>();
        HashMap<Integer,String> idx = new HashMap<>();

        int count = 1;
        for (int i = 0; i < N; i++) {
            String name = br.readLine();

            character.put(name, count);
            idx.put(count, name);

            count++;
        }

        for (int i = 0; i < M; i++) {
            String question = br.readLine();

            try {
                int index = Integer.parseInt(question);
                sb.append(idx.get(index)).append("\n");
            } catch (NumberFormatException e) {
                sb.append(character.get(question)).append("\n");
            }
        }

        System.out.print(sb);
    }
}
