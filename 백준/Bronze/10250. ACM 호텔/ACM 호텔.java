import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String[] arr = br.readLine().split(" ");
            int h = Integer.parseInt(arr[0]); // 층
            int w = Integer.parseInt(arr[1]); // 방 수
            int n = Integer.parseInt(arr[2]); // n번째 손님

            // 층수 계산
            int floor = (n - 1) % h + 1;
            // 방 번호 계산
            int room = (n - 1) / h + 1;

            // 방 번호 포맷팅
            String roomNumber = String.format("%d%02d", floor, room);

            bw.write(roomNumber + "\n");
        }

        bw.flush();
        bw.close();
    }
}
