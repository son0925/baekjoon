import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            if (word.length() >= M) {
                dictionary.put(word, dictionary.getOrDefault(word, 0) + 1);
            }
        }

        PriorityQueue<Word> pq = new PriorityQueue<>();
        for (String key : dictionary.keySet()) {
            pq.offer(new Word(key, dictionary.get(key)));
        }


        while (!pq.isEmpty()) {
            bw.write(pq.poll().word);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Word implements Comparable<Word> {

    String word;
    int count;

    public Word(String word, int count) {
        this.word = word;
        this.count = count;
    }

    @Override
    public int compareTo(Word o) {
        if (this.count != o.count) {
            return Integer.compare(o.count, this.count);
        }

        if (this.word.length() != o.word.length()) {
            return Integer.compare(o.word.length(), this.word.length());
        }

        return this.word.compareTo(o.word);
    }
}