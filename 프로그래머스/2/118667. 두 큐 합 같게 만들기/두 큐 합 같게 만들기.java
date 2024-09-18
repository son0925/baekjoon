import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long q1Sum = 0;
        long q2Sum = 0;
        int n = queue1.length + queue2.length + 1;
        
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q1Sum += queue1[i];
        }
        
        for (int i = 0; i < queue2.length; i++) {
            q2.add(queue2[i]);
            q2Sum += queue2[i];
        }
        
        long target = (q1Sum + q2Sum) / 2;
        
        
        int count = 0;
        while (q1Sum != target && count <= n) {
            count++;
            if (q1Sum < target) {
                int num = q2.poll();
                q1.add(num);
                q1Sum += num;
            } else {
                int num = q1.poll();
                q2.add(num);
                q1Sum -= num;
            }
        }
        
        if (q1Sum == target) {
            return count;
        }
        return -1;
    }
}