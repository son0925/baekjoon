import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        List<int[]> meetings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            meetings.add(new int[]{in.nextInt(), in.nextInt()});
        }

        meetings.sort((o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];  
            } else {
                return o1[0] - o2[0];  
            }
        });

        int count = 0;
        int lastEndTime = 0;

        for (int[] meeting : meetings) {
            if (meeting[0] >= lastEndTime) {
                count++;
                lastEndTime = meeting[1];
            }
        }

        System.out.println(count);
    }
}
