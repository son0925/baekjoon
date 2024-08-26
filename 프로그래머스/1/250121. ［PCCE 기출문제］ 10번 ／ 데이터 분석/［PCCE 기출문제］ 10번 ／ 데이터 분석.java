import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        
        // 필터링 기준 인덱스 설정
        int compareIndex = getIndex(ext);
        
        // 필터링
        for (int[] datum : data) {
            if (datum[compareIndex] <= val_ext) {
                list.add(datum);
            }
        }
        
        // 결과 배열로 변환
        int[][] result = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        // 정렬 기준 인덱스 설정
        int sortedIndex = getIndex(sort_by);
        
        // 정렬 수행
        sortedArr(result, sortedIndex);
        
        return result;
    }
    
    // 기준 인덱스 가져오기
    public int getIndex(String key) {
        switch (key) {
            case "code": return 0;
            case "date": return 1;
            case "maximum": return 2;
            case "remain": return 3;
            default: return -1;
        }
    }
    
    // 배열 정렬 메소드 (삽입 정렬)
    public void sortedArr(int[][] arr, int index) {
        for (int i = 1; i < arr.length; i++) {
            int[] target = arr[i];
            int j = i - 1;
            
            // 비교하여 삽입 위치 찾기
            while (j >= 0 && arr[j][index] > target[index]) {
                arr[j + 1] = arr[j];  // 이동
                j--;
            }
            arr[j + 1] = target;  // 삽입
        }
    }
}
