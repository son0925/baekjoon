import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static long result = -1;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        long[][] arr = new long[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Board board = new Board(arr);

        recursion(board, 0);

        System.out.println(result);
    }

    public static void recursion(Board board, int turn) {
        if (turn == 5) {
            result = Math.max(result, board.getMaxValue());
            return;
        }

        Board copyBoard = new Board(board);
        copyBoard.up();
        recursion(copyBoard, turn+1);

        copyBoard = new Board(board);
        copyBoard.down();
        recursion(copyBoard, turn+1);

        copyBoard = new Board(board);
        copyBoard.left();
        recursion(copyBoard, turn+1);

        copyBoard = new Board(board);
        copyBoard.right();
        recursion(copyBoard, turn+1);
    }
}

class Board {

    private Block[][] blockArr;
    private int n;

    public Board(long[][] arr) {
        n = arr.length;

        blockArr = new Block[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0) {
                    blockArr[i][j] = new Block(arr[i][j]);
                }
            }
        }
    }

    public Board(Board o) {
        this.n = o.n;
        blockArr = new Block[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (o.blockArr[i][j] != null) {
                    this.blockArr[i][j] = new Block(o.blockArr[i][j]);
                }
            }
        }
    }

    public void up() {
        flagClear();

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (blockArr[i][j] == null) {
                    continue;
                }

                int nx = 0;

                // i 보다 작아야 하며 해당 블럭이 null 일 때 종료
                while (nx < i && blockArr[nx][j] != null) {
                    nx++;
                }

                // 이동
                if (nx != i) {
                    blockArr[nx][j] = new Block(blockArr[i][j]);
                    blockArr[i][j] = null;
                }

                // 병합
                if (nx - 1 >= 0 && blockArr[nx-1][j] != null && blockArr[nx-1][j].equals(blockArr[nx][j])) {
                    blockArr[nx-1][j].merge(blockArr[nx][j]);
                    blockArr[nx][j] = null;
                }
            }
        }
    }

    public void down() {
        flagClear();

        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (blockArr[i][j] == null) {
                    continue;
                }

                int nx = n-1;
                while (nx > i && blockArr[nx][j] != null) {
                    nx--;
                }

                // 이동
                if (nx != i) {
                    blockArr[nx][j] = new Block(blockArr[i][j]);
                    blockArr[i][j] = null;
                }

                // 병합
                if (nx + 1 < n && blockArr[nx+1][j] != null && blockArr[nx+1][j].equals(blockArr[nx][j])) {
                    blockArr[nx+1][j].merge(blockArr[nx][j]);
                    blockArr[nx][j] = null;
                }
            }
        }
    }

    public void right() {
        flagClear();

        for(int i = 0; i < n; i++) {
            for (int j = n-2; j >= 0; j--) {
                if (blockArr[i][j] == null) {
                    continue;
                }

                int ny = n-1;
                while(ny > j && blockArr[i][ny] != null) {
                    ny--;
                }

                if (ny != j) {
                    blockArr[i][ny] = new Block(blockArr[i][j]);
                    blockArr[i][j] = null;
                }

                if (ny+1 < n&& blockArr[i][ny+1] != null && blockArr[i][ny+1].equals(blockArr[i][ny])) {
                    blockArr[i][ny+1].merge(blockArr[i][ny]);
                    blockArr[i][ny] = null;
                }
            }
        }
    }

    public void left() {
        flagClear();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (blockArr[i][j] == null) {
                    continue;
                }

                int ny = 0;

                while (ny < j && blockArr[i][ny] != null) {
                    ny++;
                }

                if (ny != j) {
                    blockArr[i][ny] = new Block(blockArr[i][j]);
                    blockArr[i][j] = null;
                }

                if (ny - 1 >= 0 && blockArr[i][ny-1] != null && blockArr[i][ny-1].equals(blockArr[i][ny])) {
                    blockArr[i][ny-1].merge(blockArr[i][ny]);
                    blockArr[i][ny] = null;
                }
            }
        }
    }

    private void flagClear() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (blockArr[i][j] != null) {
                    blockArr[i][j].flag = true;
                }
            }
        }
    }

    public long getMaxValue() {
        long result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (blockArr[i][j] == null) {
                    continue;
                }
                result = Math.max(result, blockArr[i][j].value);
            }
        }

        return result;
    }


    public void print() {
        for (Block[] arr : blockArr) {
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("---------------------------------");
    }


    private static class Block {
        private long value;
        private boolean flag;

        public Block(long value) {
            this.value = value;
            flag = true;
        }

        public Block(Block o) {
            if (o == null) {
                return;
            }

            this.value = o.value;
            this.flag = o.flag;
        }

        public void merge(Block other) {
            this.value += other.value;
            this.flag = false;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }

            if (obj instanceof Block) {
                Block o = (Block) obj;
                return this.value == o.value && this.flag && o.flag;
            }

            return false;
        }

        @Override
        public String toString() {
            return "" + this.value;
        }
    }

}