import java.util.*;
import java.io.*;

public class Main {

    static int[] arr;
    static int[] tmp;
    static int M;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        M = in.nextInt();


        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        tmp = new int[N];

        mergeSort(0, N-1);


        if (count < M) {
            System.out.println(-1);
        }
    }

    public static void mergeSort(int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(left, mid);
        mergeSort(mid+1, right);

        merge(left, mid, right);
    }

    public static void merge(int left, int mid, int right) {
        int l = left;
        int r = mid+1;
        int idx = left;


        while (l <= mid && r <= right) {

            if (arr[l] <= arr[r]) {
                tmp[idx++] = arr[l++];
            }
            else {
                tmp[idx++] = arr[r++];
            }

        }


        while (r <= right) {
            tmp[idx++] = arr[r++];
        }

        while (l <= mid) {
            tmp[idx++] = arr[l++];
        }

        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
            count++;

            if (count == M) {
                System.out.println(arr[i]);
            }
        }
    }
}