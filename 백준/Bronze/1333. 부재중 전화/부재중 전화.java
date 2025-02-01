import java.util.*;
import java.io.*;

/*
자료구조 없음
로직
1. 노래가 끝나는 시간을 파악하기
2. 노래가 끝나는 시점부터 다시 시작하기 전 까지 5초동안 알람이 울리는지 확인하기
3. 알림이 울리지 않는다면 +5 +L하기

알림 관리
1. 현재 시간이 알람이 이미 울렸는지 확인(이미 시간이 지났는지)
2. 시간이 지났다면 += D 해주기
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // N개의 노래
        int L = Integer.parseInt(st.nextToken()); // 노래의 길이는 L초
        int D = Integer.parseInt(st.nextToken()); // D초마다 전화가 올림

        List<Boolean> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < L; j++) {
                list.add(true);
            }

            if (i < N-1) {
                for (int j = 0; j < 5; j++) {
                    list.add(false);
                }
            }
        }

        int result = 0;

        while (result < list.size()) {
            if (!list.get(result)) {
                break;
            }

            result += D;
        }

        System.out.println(result);
    }
}