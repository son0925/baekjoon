class Solution {
    public int solution(String skill, String[] skill_trees) {
        int result = 0;
        
        for (String s : skill_trees) {
            // skill 문자열의 순서에 맞는지
            int currentIndex = 0;
            
            // 올바른 스킬트리인지 확인
            boolean check = true;
            for (int i = 0; i < s.length(); i++) {
                
                int idx = getIndex(skill, s.charAt(i));
                
                // 필수로 스킬트리를 올리는 스킬이 아닐 때 continue;
                if (idx == -1) continue;
                
                // 필수 스킬트리이며 올바른 스킬 순서라면 currentIndex+1
                if (idx == currentIndex) currentIndex++;
                // 올바른 스킬트리가 아닐 때
                else {
                    check = false;
                    break;
                }
            }
            if (check) result++;
        }
        return result;
    }
    
    // 스킬의 index를 반환 없으면 -1
    public static int getIndex(String skill, char c) {
        char[] skillArr = skill.toCharArray();
        
        int index = -1;
        for (int i = 0; i < skillArr.length; i++) {
            if (skillArr[i] == c) {
                index = i;
                break;
            }
        }
        return index;
    }
}