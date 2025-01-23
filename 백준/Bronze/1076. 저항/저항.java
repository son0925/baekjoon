import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Map<String, Integer> valueMap = initValueMap();
        Map<String, Long> multiplierMap = initMultiplierMap();

        long value = valueMap.get(br.readLine()) * 10L + valueMap.get(br.readLine());
        long multiplier = multiplierMap.get(br.readLine());

        long result = value * multiplier;

        System.out.println(result);
    }

    public static HashMap<String, Integer> initValueMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("black", 0);
        map.put("brown", 1);
        map.put("red", 2);
        map.put("orange", 3);
        map.put("yellow", 4);
        map.put("green", 5);
        map.put("blue", 6);
        map.put("violet", 7);
        map.put("grey", 8);
        map.put("white", 9);
        return map;
    }

    public static HashMap<String, Long> initMultiplierMap() {
        HashMap<String, Long> map = new HashMap<>();
        map.put("black", 1L);
        map.put("brown", 10L);
        map.put("red", 100L);
        map.put("orange", 1_000L);
        map.put("yellow", 10_000L);
        map.put("green", 100_000L);
        map.put("blue", 1_000_000L);
        map.put("violet", 10_000_000L);
        map.put("grey", 100_000_000L);
        map.put("white", 1_000_000_000L);
        return map;
    }
}