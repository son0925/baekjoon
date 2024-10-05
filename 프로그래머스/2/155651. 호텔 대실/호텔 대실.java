import java.util.*;

class Solution implements Comparator<int[]> {
    public int solution(String[][] book_time) {
        List<List<int[]>> reservationList = new ArrayList<>();
        int[][] bookTime = initBookTime(book_time);
        
        Arrays.sort(bookTime, this);
        
        for (int[] arr : bookTime) {
            checkReservation(reservationList, arr);
        }
        
        // debuging(reservationList);
        
        return reservationList.size();
    }
    
    public int[][] initBookTime(String[][] book_time) {
        int[][] bookTime = new int[book_time.length][2];
        
        for (int i = 0; i < bookTime.length; i++) {
            for (int j = 0; j < 2; j++) {
                bookTime[i][j] = getMin(book_time[i][j]);
                
                if (j == 1) bookTime[i][j] += 10;
            }
        }
        
        return bookTime;
    }
    
    @Override
    public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[0], o2[0]);
    }
    
    public void checkReservation(List<List<int[]>> reservationList, int[] arr) {
        for (List<int[]> compareList : reservationList) {
            boolean isAble = true;
            for (int[] compareArr : compareList) {
                if (compareArr[0] < arr[1] && compareArr[1] > arr[0]) {
                    isAble = false;
                }
            }
            if (isAble) {
                compareList.add(arr);
                return;
            }
        }
        
        List<int[]> list = new ArrayList<>();
        list.add(arr);
        reservationList.add(list);
    }
    
    public int getMin(String time) {
        int result = 0;
        
        String[] timeArr = time.split(":");
        result += Integer.parseInt(timeArr[1]);
        result += Integer.parseInt(timeArr[0]) * 60;
        
        return result;
    }
    
    public void debuging(List<List<int[]>> reservationList) {
        for (List<int[]> list : reservationList) {
            for (int[] arr : list) {
                System.out.print(Arrays.toString(arr) + " ");
            }
            System.out.println();
        }
    }
}
