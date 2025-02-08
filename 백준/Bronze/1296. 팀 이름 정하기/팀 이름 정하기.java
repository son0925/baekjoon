import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String LOVE = "LOVE";
        String name = br.readLine();

        int N = Integer.parseInt(br.readLine());
        String[] teams = new String[N];
        for (int i = 0; i < N; i++) {
            teams[i] = br.readLine();
        }

        int[] score = new int[N];
        for (int i = 0; i < N; i++) {
            String team = name + teams[i];

            int[] count = new int[4];
            for (int j = 0; j < LOVE.length(); j++) {
                for (int k = 0; k < team.length(); k++) {
                    if (LOVE.charAt(j) == team.charAt(k)) {
                        count[j]++;
                    }
                }
            }

            int result = 1;
            for (int j = 0; j < 3; j++) {
                for (int k = j+1; k < 4; k++) {
                    result = (count[j] + count[k]) * result % 100;
                }
            }

            score[i] = result;
        }

        int max = -1;
        List<String> list = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            if (score[i] > max) {
                list = new ArrayList<>();
                list.add(teams[i]);
                max = score[i];
            } else if (score[i] == max) {
                list.add(teams[i]);
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0));
    }
}