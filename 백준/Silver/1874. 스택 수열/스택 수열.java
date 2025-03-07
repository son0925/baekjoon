import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stk = new Stack<>();
        int num = 1; // 스택에 넣는 수
        int idx = 0; // arr idx

        /**
         * 1. 스택이 비어있는지 확인한다
         *  - 스택이 비어있다면 요소 추가하고 continue;
         * 2. 제일 위 요소와 arr[idx] 요소와 비교하기(다를 때 까지 반복하기)
         *  - 만약 같다면 pop
         *  - 다르다면 break;
         * 3. 모든 비교가 종료되었을 때 stk에 요소가 남아있다면 "NO" 출력 없다면 연산 + 혹은 - 출력
         */


        while (num <= N) {
            while(!stk.isEmpty() && stk.peek() == arr[idx]) {
                stk.pop();
                idx++;
                sb.append("-").append("\n");
            }

            stk.push(num++);
            sb.append("+").append("\n");
        }

        while(!stk.isEmpty() && stk.peek() == arr[idx]) {
            stk.pop();
            idx++;
            sb.append("-").append("\n");
        }

        if (stk.isEmpty()) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }

    }
}