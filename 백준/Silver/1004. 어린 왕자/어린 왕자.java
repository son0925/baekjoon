import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Main.solution();
        }

        System.out.println(sb);
    }

    public static void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        SpaceCraft spaceCraft = new SpaceCraft(st);

        int N = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            Planet planet = new Planet(st);

            result += planet.isContains(spaceCraft);
        }

        sb.append(result).append("\n");
    }
}

class SpaceCraft {
    int startX;
    int startY;
    int endX;
    int endY;

    public SpaceCraft(StringTokenizer st) {
        this.startX = Integer.parseInt(st.nextToken());
        this.startY = Integer.parseInt(st.nextToken());
        this.endX = Integer.parseInt(st.nextToken());
        this.endY = Integer.parseInt(st.nextToken());
    }
}

class Planet {
    int x;
    int y;
    int r;

    public Planet(StringTokenizer st) {
        this.x = Integer.parseInt(st.nextToken());
        this.y = Integer.parseInt(st.nextToken());
        this.r = Integer.parseInt(st.nextToken());
    }

    public int isContains(SpaceCraft spaceCraft) {
        int result = 0;

        if (r*r >= Math.pow(spaceCraft.startX - this.x, 2) + Math.pow(spaceCraft.startY - this.y, 2)) {
            result++;
        }

        if (r*r >= Math.pow(spaceCraft.endX - this.x, 2) + Math.pow(spaceCraft.endY - this.y, 2)) {
            result++;
        }

        if (result == 2) {
            result = 0;
        }

        return result;
    }
}