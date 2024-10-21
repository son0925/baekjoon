import java.util.*;


public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        in.nextLine();

        List<String> list = new ArrayList<>(Arrays.asList(in.nextLine().split(" ")));

        int[] arr = list.stream()
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr);

        int s = 0;
        int e = n-1;

        int min = arr[s];
        int max = arr[e];
        int diff = Math.abs(min + max);


        while (s < e) {
            if (diff > Math.abs(arr[s] + arr[e])) {
                diff = Math.abs(arr[s] + arr[e]);
                min = arr[s];
                max = arr[e];
            }

            if (Math.abs(arr[s]) < Math.abs(arr[e])) {
                e--;
            } else {
                s++;
            }
        }

        System.out.println(min + " " + max + " " + diff);
    }
}