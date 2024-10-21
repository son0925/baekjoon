import java.util.*;

public class Main {

    static String[][] maze;
    static int rows, cols;
    static int[] dRow = {1, -1, 0, 0};
    static int[] dCol = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        rows = in.nextInt();
        cols = in.nextInt();
        in.nextLine();

        maze = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String line = in.nextLine();
            for (int j = 0; j < cols; j++) {
                maze[i][j] = String.valueOf(line.charAt(j));
            }
        }

        bfs();
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        boolean[][] visit = new boolean[rows][cols];
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curRow = current[0];
            int curCol = current[1];
            int steps = current[2];

            if (curRow == rows - 1 && curCol == cols - 1) {
                System.out.println(steps);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = curRow + dRow[i];
                int newCol = curCol + dCol[i];

                if (newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols
                        && maze[newRow][newCol].equals("1") && !visit[newRow][newCol]) {
                    visit[newRow][newCol] = true;
                    queue.add(new int[]{newRow, newCol, steps + 1});
                }
            }
        }

        System.out.println("경로를 찾을 수 없습니다");
    }
}