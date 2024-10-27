import java.util.*;

public class Main {

    static int min = Integer.MAX_VALUE;  
    static int[][] map; 
    static int T;  

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        T = in.nextInt();
        map = new int[T][T];
        boolean[] visit = new boolean[T];  

        // 능력치 입력
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < T; j++) {
                map[i][j] = in.nextInt();
            }
        }
        recursion(visit, T/2, 0);
        System.out.println(min); 
    }

    public static void recursion(boolean[] visit, int count, int start) {
        if (count == 0) {
            diff(visit); 
            return;
        }

        for (int i = start; i < T; i++) {  
            if (!visit[i]) {
                visit[i] = true;  
                recursion(visit, count - 1, i + 1); 
                visit[i] = false; 
            }
        }
    }

    public static void diff(boolean[] visit) {
        int startSum = 0;
        int linkSum = 0;

        for (int i = 0; i < T; i++) {
            for (int j = 0; j < T; j++) {
                if (visit[i] && visit[j]) {
                    startSum += map[i][j];  
                } else if (!visit[i] && !visit[j]) {
                    linkSum += map[i][j];  
                }
            }
        }

        min = Math.min(min, Math.abs(startSum - linkSum));  
    }
}
