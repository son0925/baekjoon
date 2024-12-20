import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(in.nextLine());

        String[] cardArr = in.nextLine().split(" ");
        Map<String,Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(cardArr[i], map.getOrDefault(cardArr[i], 0) + 1);
        }

        int M = Integer.parseInt(in.nextLine());
        String[] compareCardArr = in.nextLine().split(" ");

        for (int i = 0; i < M; i++) {
            sb.append(map.getOrDefault(compareCardArr[i], 0)).append(" ");
        }


        System.out.println(sb.toString().trim());
    }
}