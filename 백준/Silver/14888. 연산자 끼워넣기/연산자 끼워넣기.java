import java.util.*;
import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[] arr;
    static int[] operatorArr;

    static long max;
    static long min;

    public static void main(String[] args) throws IOException {
        //  초기화 시작
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        operatorArr = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operatorArr[i] = Integer.parseInt(st.nextToken());
        }

        max = -1_000_000_000L;
        min = 1_000_000_000L;

        // 초기화 끝

        recursion(arr[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    public static void recursion(long curNum, int idx) {
        if (idx == n) {
            max = Math.max(max, curNum);
            min = Math.min(min, curNum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operatorArr[i] <= 0) {
                continue;
            }

            operatorArr[i]--;
            if (i == 0) {
                recursion(add(curNum, idx), idx+1);
            } else if (i == 1) {
                recursion(subtract(curNum, idx), idx+1);
            } else if (i == 2) {
                recursion(multiply(curNum, idx), idx+1);
            } else {
                recursion(division(curNum, idx), idx+1);
            }
            operatorArr[i]++;
        }
    }

    public static long add(long cur, int idx) {
        return cur + arr[idx];
    }

    public static long multiply(long cur, int idx) {
        return cur * arr[idx];
    }

    public static long subtract(long cur, int idx) {
        return cur - arr[idx];
    }

    public static long division(long cur, int idx) {
        if (cur == 0) {
            return 0;
        }

        if (cur < 0) {
            cur *= -1;
            return cur / arr[idx] * -1;
        }

        return cur / arr[idx];
    }
}