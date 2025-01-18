import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        double n = Double.parseDouble(br.readLine());

        System.out.println((n * n * Math.sqrt(3)) / 4);
    }
}