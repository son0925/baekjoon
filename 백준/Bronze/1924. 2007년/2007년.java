import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        DayOfWeek dayOfWeek;


        StringTokenizer st = new StringTokenizer(br.readLine());

        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < month-1; i++) {
            sum += days[i];
        }

        System.out.println(DayOfWeek.values()[(sum + day) % 7]);
    }
}

enum DayOfWeek {
    SUN, MON, TUE, WED, THU, FRI, SAT
}