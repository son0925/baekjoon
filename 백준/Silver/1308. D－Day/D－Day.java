import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int Tyear = Integer.parseInt(st.nextToken());
        int Tmonth = Integer.parseInt(st.nextToken());
        int Tday = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int Dyear = Integer.parseInt(st.nextToken());
        int Dmonth = Integer.parseInt(st.nextToken());
        int Dday = Integer.parseInt(st.nextToken());

        if ((Dyear - Tyear > 1000) || (Dyear - Tyear == 1000 && Dmonth > Tmonth)
                || (Dyear - Tyear == 1000 && Dmonth == Tmonth && Dday >= Tday))
            System.out.println("gg");
        else {
            long TFindingDays = findingDays(Tyear, Tmonth, Tday);
            long DFindingDays = findingDays(Dyear, Dmonth, Dday);
            System.out.println("D-" + (DFindingDays - TFindingDays));
        }
    }

    public static int[] dayArray(int year) {
        int[] day = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            day[1] = 29;
        return day;
    }

    public static long findingDays(int year, int month, int day) {
        long days = 0;
        int[] date;
        for (int i = 1; i < year; i++) {
            date = dayArray(i);
            for (int j = 0; j < 12; j++) {
                days += date[j];
            }
        }

        date = dayArray(year);
        for (int i = 0; i < month-1; i++) {
            days += date[i];
        }
        days += day;
        return days;
    }
}