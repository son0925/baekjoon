import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String IOI = br.readLine();

        int count = 0;
        int result = 0;
        for (int i = 1; i < M-1;i++) {
            if (IOI.charAt(i) == 'O' && IOI.charAt(i+1) == 'I') {
                count++;

                if (count == N) {
                    if (IOI.charAt(i - (2*count-1)) == 'I') {
                        result++;
                    }

                    count--;
                }

                i++;
            } else {
                count = 0;
            }
        }

        System.out.println(result);
    }
}