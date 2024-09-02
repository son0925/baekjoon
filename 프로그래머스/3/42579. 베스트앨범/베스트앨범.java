import java.util.*;

class Solution {
    // 장르별 최대 2개
    // 장르별 재생횟수 내림차순
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> list = new ArrayList<>();
        Map<String,Integer> totalPlays = initTotalPlays(genres, plays);
        
        
        // 카테고리 별 재생횟수 내림차순
        List<String> genresList = sortedGenres(totalPlays);
        
        initMap(genresList, genres, plays, list);
        
        // result 생성
        int[] result = initResult(list);
        return result;
    }
    
    public void initMap(List<String> genresList, String[] genres, int[] plays, List<Integer> result) {
        for (String category : genresList) {
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(category)) {
                    list.add(new int[]{plays[i], i});
                }
            }
            list.sort(new Comparator<int[]>() {
               @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return Integer.compare(o1[1],o2[1]);
                    }
                    return Integer.compare(o2[0], o1[0]);
                }
            });
            
            for (int i = 0; i < list.size(); i++) {
                if (i == 2) break;
                
                result.add(list.get(i)[1]);
            }
        }
    }
    
    // 카테고리 별 map 생성
    public HashMap<String,Integer> initTotalPlays(String[] genres, int[] plays) {
        HashMap<String,Integer> totalPlays = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
        }
        return totalPlays;
    }
    
    // 카테고리 리스트 생성(총 재생횟수 내림차순)
    public ArrayList<String> sortedGenres(Map<String,Integer> totalPlays) {
        ArrayList<String> list = new ArrayList<>(totalPlays.keySet());
        list.sort((o1, o2) -> totalPlays.get(o2).compareTo(totalPlays.get(o1)));
        return list;
    }
    
    // result 생성 메소드
    public int[] initResult(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}