import java.util.Scanner;

public class Main {

    static boolean[] brokenButton;
    static int count;
    static int target;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        target = in.nextInt();

        // 목표 채널이 100일 때
        if (target == 100) {
            System.out.println(0);
            return;
        }


        int n = in.nextInt();

        // 고장난 버튼들
        brokenButton = new boolean[10];
        for (int i = 0; i < n; i++) {
            brokenButton[in.nextInt()] = true;
        }



        count = Math.abs(target - 100);

        // 자릿수, 해당 자릿수까지 숫자
        dfs(0, 0);
        System.out.println(count);
    }

    public static void dfs(int idx, int curChannel) {
        for (int i = 0; i < 10; i++) {
            if (!brokenButton[i]) {
                int channel = curChannel * 10 + i;

                // 타겟 채널과 거리 + 채널 자릿수
                int cnt = Math.abs(target - channel) + ("" + channel).length();
                
                count = Math.min(cnt, count);

                // 6자리를 넘지 않는다면 (최댓값은 500000)
                if (idx < 6) {
                    dfs(idx+1, channel);
                }
            }
        }
    }
}
