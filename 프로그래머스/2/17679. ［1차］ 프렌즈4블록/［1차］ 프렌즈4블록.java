import java.util.*;

class Solution {
    // 삭제를 하는 방법
    // 1. 한 라인에 2개가 존재할 시 밑에 2개 확인하기
    // 만약 2x2 정사각형이라면 queue에 저장하여 삭제할 index 저장하기
    // 삭제한 순간 m축 내리기
    public int solution(int m, int n, String[] board) {
        int result = 0;
        // 게임 맵 생성
        char[][] map = initArr(m, n, board);
        
        // 게임 시작
        boolean isRunning = true;
        while (isRunning) {
            isRunning = false;
            Queue<String> q = new LinkedList<>();
            for (int i = 0; i < m-1; i++) {
                for (int j = 0; j < n-1; j++) {
                    if (map[i][j] != '0' && map[i][j] == map[i][j+1]
                       && map[i][j] == map[i+1][j]
                       && map[i+1][j] == map[i+1][j+1]) {
                        isRunning = true;
                        
                        if (!q.contains(i+" "+j))
                            q.add(i+" "+j);
                        if (!q.contains(i+" "+(j+1)))
                            q.add(i+" "+(j+1));
                        if (!q.contains((i+1)+" "+j))
                            q.add((i+1)+" "+j);
                        if (!q.contains((i+1)+" "+(j+1)))
                            q.add((i+1)+" "+(j+1));
                    }
                }
            }
            result += q.size();
            while (!q.isEmpty()) {
                String[] tmpArr = q.poll().split(" ");
                map[Integer.parseInt(tmpArr[0])][Integer.parseInt(tmpArr[1])] = '0';
            }
            blockMove(m,n,map);
        }
        
        
        
        return result;
    }
    
    public void showArray(char[][] map) {
        for (char[] cArr : map) {
            System.out.println(Arrays.toString(cArr));
        }
    }
    
    public void blockMove(int m, int n, char[][] map) {
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                int ni = i;
                while (m-1 > ni && map[ni+1][j] == '0') {
                    map[ni+1][j] = map[ni][j];
                    map[ni][j] = '0';
                    ni++;
                }
            }
        }
    }
    
    public char[][] initArr(int m, int n, String[] board) {
        char[][] arr = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = board[i].charAt(j);
            }
        }
        return arr;
    }
}