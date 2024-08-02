import java.util.*;

class Solution {

    static int n;
    static int answer;
    
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;

        // words 배열에 target이 존재하지 않는다면 바로 리턴하기
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
        
        n = begin.length();
        boolean[] visited = new boolean[words.length];
        dfs(begin, target, words, visited, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    static void dfs(String currentWord, String target, String[] words, boolean[] visited, int result) {
        if (currentWord.equals(target)) {
            answer = Math.min(result, answer);
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && canTransform(currentWord, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, visited, result + 1);
                visited[i] = false; 
            }
        }
    }
    
    static boolean canTransform(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}
