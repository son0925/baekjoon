import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] switchArr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        switchInit();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            run();
        }
        print();
    }

    public static void run() throws IOException {
        st = new StringTokenizer(br.readLine());

        int gender = Integer.parseInt(st.nextToken());
        int number = Integer.parseInt(st.nextToken());

        if (gender == 1) {
            man(number);
        } else {
            woman(number);
        }
    }

    public static void print() {
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            sb.append(switchArr[i]).append(" ");
            
            if (i % 20 == 0) {
                result.append(sb.toString().trim()).append("\n");
                sb = new StringBuilder();
            }
        }
        
        if (sb.length() > 0) {
            result.append(sb.toString().trim());
        }

        System.out.println(result.toString().trim());
    }

    public static void man(int num) {
        for (int i = num; i <= N; i+=num) {
            onOff(i);
        }
    }
    public static void woman(int num) {
        int l = num-1;
        int r = num+1;

        onOff(num);

        while (l > 0 && r <= N) {
            if (switchArr[l] == switchArr[r]) {
                onOff(l);
                onOff(r);
                l--;
                r++;
            } else {
                break;
            }
        }
    }

    public static void onOff(int idx) {
        switchArr[idx] = (switchArr[idx] + 1) % 2;
    }

    public static void switchInit() throws IOException {
        switchArr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            switchArr[i] = Integer.parseInt(st.nextToken());
        }
    }
}