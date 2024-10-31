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

        HashMap<String,String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");

            map.put(tmp[0], tmp[1]);
        }


        for (int i = 0; i < M; i++) {
            System.out.println(map.get(br.readLine()));
        }
    }
}