import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        SegmentTree segTree = new SegmentTree(N);
        long[] arr = new long[N + 1];
        segTree.init(arr, 1, N, 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if (cmd == 0) {
                int start = Math.min(a, (int) b);
                int end = Math.max(a, (int) b);
                bw.write(segTree.sum(1, 1, N, start, end) + "\n");
            } else {
                segTree.modify(1, 1, N, a, b - arr[a]);
                arr[a] = b;
            }
        }

        bw.flush();
    }
}

class SegmentTree {
    long[] tree;

    public SegmentTree(int n) {
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        int size = (int) Math.pow(2, h + 1);
        tree = new long[size];
    }

    public void modify(int curNode, int left, int right, int target, long diff) {
        if (target < left || target > right) {
            return;
        }

        tree[curNode] += diff;

        if (left != right) {
            int mid = (left + right) / 2;
            modify(curNode * 2, left, mid, target, diff);
            modify(curNode * 2 + 1, mid + 1, right, target, diff);
        }
    }

    public long init(long[] arr, int left, int right, int curNode) {
        if (left == right) {
            return tree[curNode] = arr[left];
        }

        int mid = (left + right) / 2;
        return tree[curNode] =
                init(arr, left, mid, curNode * 2)
                        + init(arr, mid + 1, right, curNode * 2 + 1);
    }

    public long sum(int curNode, int left, int right, int start, int end) {
        if (right < start || left > end) {
            return 0;
        }

        if (start <= left && right <= end) {
            return tree[curNode];
        }

        int mid = (left + right) / 2;
        return sum(curNode * 2, left, mid, start, end)
                + sum(curNode * 2 + 1, mid + 1, right, start, end);
    }
}