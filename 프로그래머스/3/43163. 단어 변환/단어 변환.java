import java.util.*;

class Solution {
    class Word {
        String word;
        int count;
        
        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    public int solution(String begin, String target, String[] words) {
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, 0));
        boolean[] visited = new boolean[words.length];
        int result = Integer.MAX_VALUE;
        
        while(!q.isEmpty()) {
            Word word = q.poll();
            String currentWord = word.word;
            int count = word.count;
            
            
            if (currentWord.equals(target)) {
                result = Math.min(result, count);
                break;
            } 
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isTransForm(currentWord, words[i])) {
                    visited[i] = true;
                    q.add(new Word(words[i], count+1));
                }
            }
        }
        if (result == Integer.MAX_VALUE) {
            return 0;
        }
        return result;
    }
    
    static boolean isTransForm(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (++count > 1) return false;
            }
        }
        
        return true;
    }
}