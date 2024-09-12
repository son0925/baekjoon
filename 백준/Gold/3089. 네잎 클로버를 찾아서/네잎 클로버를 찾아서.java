import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, TreeSet<Pos>> xMap = new HashMap<>();
        Map<Integer, TreeSet<Pos>> yMap = new HashMap<>();

        while (n-->0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (!xMap.containsKey(x)) xMap.put(x, new TreeSet<>((o1, o2) -> o1.y - o2.y));
            if (!yMap.containsKey(y)) yMap.put(y, new TreeSet<>((o1, o2) -> o1.x - o2.x));

            Pos pos = new Pos(x, y);
            xMap.get(x).add(pos);
            yMap.get(y).add(pos);
        }

        String dir = br.readLine();
        Pos cur = new Pos(0, 0);
        for (int i = 0; i < m; i++) {
            switch (dir.charAt(i)) {
                case 'R': cur = yMap.get(cur.y).higher(cur); break;
                case 'L': cur = yMap.get(cur.y).lower(cur); break;
                case 'U': cur = xMap.get(cur.x).higher(cur); break;
                case 'D': cur = xMap.get(cur.x).lower(cur); break;
            }
        }
        System.out.println(cur);
    }
}

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}