import java.util.*;

class Solution {
    public int solution(String A, String B) {
        Deque<String> deque = new ArrayDeque<>();
        
        for (String s : A.split("")) {
            deque.add(s);
        }
        
        for (int i = 0; i < A.length(); i++) {
            if (String.join("",deque).equals(B)) {
                return i;
            }
            deque.addFirst(deque.pollLast());
            
        }
        
        return -1;
    }
}