import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        sb.append(getAvg(arr, N)).append("\n");
        sb.append(getMedianValue(arr, N)).append("\n");
        sb.append(getMode(arr, N)).append("\n");
        sb.append(arr[N-1] - arr[0]);


        System.out.println(sb);
    }

    public static int getMode(int[] arr, int N) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int key = arr[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());

        // 정렬
        entryList.sort((o1, o2) -> {
            if (!o1.getValue().equals(o2.getValue())) {
                return o2.getValue() - o1.getValue(); // 빈도수 내림차순
            }
            return o1.getKey() - o2.getKey(); // 값 오름차순
        });

        if (entryList.size() < 2) {
            return entryList.get(0).getKey();
        }

        if (entryList.get(0).getValue() == entryList.get(1).getValue()) {
            return entryList.get(1).getKey();
        }

            return entryList.get(0).getKey();
    }

    public static int getMedianValue(int[] arr, int N) {
        return arr[N / 2];
    }

    public static int getAvg(int[] arr, int N) {
        double sum = 0;

        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }

        return (int) Math.round(sum / N);
    }
}