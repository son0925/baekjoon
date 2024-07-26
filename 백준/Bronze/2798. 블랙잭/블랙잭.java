import java.util.*;

public class Main {
    static int maximum = 0;
    static int maxNum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 첫 번째 입력을 한 줄로 읽어 처리
        String input1 = sc.nextLine();
        String[] str = input1.split(" ");
        
        // 카드 개수
        int cardCount = Integer.parseInt(str[0]);
        // 카드 최댓값
        maxNum = Integer.parseInt(str[1]);
        
        // 카드를 저장할 배열
        int[] cardArr = new int[cardCount];
        
        // 두 번째 입력을 한 줄로 읽어 처리
        String input2 = sc.nextLine();
        String[] cards = input2.split(" ");
        for (int i = 0; i < cardCount; i++) {
            cardArr[i] = Integer.parseInt(cards[i]);
        }
        
        // 해당 카드를 방문했는지
        boolean[] visited = new boolean[cardCount];
        
        combination(cardArr, visited, 0, cardCount, 3);
        
        System.out.println(maximum);
    }
    
    public static void combination(int[] cardArr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            isMaximum(cardArr, visited, n);
            return;
        }
        
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(cardArr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
    
    public static void isMaximum(int[] cardArr, boolean[] visited, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sum += cardArr[i];
            }
        }
        if (sum <= maxNum)
            maximum = Math.max(sum, maximum);
    }
}
