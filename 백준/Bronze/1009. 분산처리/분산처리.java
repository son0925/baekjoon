import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = Integer.parseInt(in.nextLine());
        
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            
            int no = 1;
            
            
            for (int j = 0; j < b; j++) {
            	no *= a;
            	no %= 10;
            }
            
            if (no == 0) no = 10;
            
            System.out.println(no);
            
            in.nextLine();
        }
    }
}