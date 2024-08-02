import java.util.*;

class Solution {
    
    static int n;
    static int result = Integer.MAX_VALUE;
    static String t;
    static boolean[] visited;
    static String[] wordsArr;
    
    public int solution(String begin, String target, String[] words) {
        n = target.length();
        t = target;
        wordsArr = words;
        visited = new boolean[words.length];
        
        if (Arrays.asList(words).contains(target)) {
            dfs(begin, 0);
            return result;
        }
        return 0;
    }
    
    static void dfs(String currentWord, int count){
        if (currentWord.equals(t)) {
            result = Math.min(result, count);
            return;
        }
        
        for (int i = 0; i < wordsArr.length; i++) {
            if (!visited[i] && canTransForm(wordsArr[i], currentWord)) {
                visited[i] = true;
                dfs(wordsArr[i], count+1);
                visited[i] = false;
            }
        }
    }
    
    static boolean canTransForm(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (word1.charAt(i) == word2.charAt(i))
                count++;
        }
        
        return count == n-1;
    }
    
}