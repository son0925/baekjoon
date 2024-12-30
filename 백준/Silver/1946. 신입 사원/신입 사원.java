import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            run();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    public static void run() throws IOException {
        int N = Integer.parseInt(br.readLine());

        Applicant[] arr = new Applicant[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Applicant(br.readLine());
        }

        Arrays.sort(arr);

        int result = 1;

        Applicant now = arr[0];
        for (int i = 1; i < N; i++) {
            if (now.second > arr[i].second) {
                now = arr[i];
                result++;
            }
        }

        sb.append(result).append("\n");
    }
}

class Applicant implements Comparable<Applicant>{
    int first;
    int second;

    public Applicant(String input) {
        String[] tmp = input.split(" ");

        this.first = Integer.parseInt(tmp[0]);
        this.second = Integer.parseInt(tmp[1]);
    }

    @Override
    public int compareTo(Applicant o) {
        return Integer.compare(this.first, o.first);
    }
}