import java.util.*;

class Solution {
    // 주어진 장르와 재생 횟수 배열을 바탕으로, 각 장르에서 가장 많이 재생된 두 곡의 인덱스를 반환합니다.
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> list = new ArrayList<>();
        // 각 장르별 총 재생 횟수를 계산합니다.
        Map<String,Integer> totalPlays = initTotalPlays(genres, plays);
        
        // 장르별로 총 재생 횟수를 기준으로 내림차순으로 정렬된 장르 리스트를 생성합니다.
        List<String> genresList = sortedGenres(totalPlays);
        
        // 각 장르별로 가장 많이 재생된 두 곡의 인덱스를 리스트에 추가합니다.
        fillResultList(genresList, genres, plays, list);
        
        // 결과 리스트를 배열로 변환하여 반환합니다.
        int[] result = initResult(list);
        return result;
    }
    
    // 각 장르에서 최대 2개의 곡의 인덱스를 추출하여 결과 리스트에 추가하는 메서드
    public void fillResultList(List<String> genresList, String[] genres, int[] plays, List<Integer> result) {
        // 장르 리스트를 순회하면서 각 장르에 대해 처리합니다.
        for (String category : genresList) {
            // 현재 장르의 곡과 재생 횟수를 저장할 리스트
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(category)) {
                    // 장르와 일치하는 곡의 재생 횟수와 인덱스를 저장합니다.
                    list.add(new int[]{plays[i], i});
                }
            }
            // 재생 횟수를 기준으로 내림차순 정렬하고, 재생 횟수가 같을 경우 인덱스가 작은 순서로 정렬합니다.
            list.sort(new Comparator<int[]>() {
               @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return Integer.compare(o1[1],o2[1]);
                    }
                    return Integer.compare(o2[0], o1[0]);
                }
            });
            
            // 각 장르에서 최대 2개의 곡을 결과 리스트에 추가합니다.
            for (int i = 0; i < list.size(); i++) {
                if (i == 2) break; // 최대 2개만 추가합니다.
                result.add(list.get(i)[1]);
            }
        }
    }
    
    // 각 장르별로 총 재생 횟수를 계산하여 맵에 저장하는 메서드
    public HashMap<String,Integer> initTotalPlays(String[] genres, int[] plays) {
        HashMap<String,Integer> totalPlays = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            // 장르별로 재생 횟수를 누적합니다.
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
        }
        return totalPlays;
    }
    
    // 총 재생 횟수를 기준으로 장르를 내림차순으로 정렬한 리스트를 생성하는 메서드
    public ArrayList<String> sortedGenres(Map<String,Integer> totalPlays) {
        ArrayList<String> list = new ArrayList<>(totalPlays.keySet());
        // 총 재생 횟수를 기준으로 내림차순 정렬합니다.
        list.sort((o1, o2) -> totalPlays.get(o2).compareTo(totalPlays.get(o1)));
        return list;
    }
    
    // 결과 리스트를 배열로 변환하는 메서드
    public int[] initResult(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
