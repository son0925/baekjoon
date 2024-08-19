class Solution {
    public int solution(String word) {
        StringBuilder correntWord = new StringBuilder();
        word = word.replaceAll("A", "1");
        word = word.replaceAll("E", "2");
        word = word.replaceAll("I", "3");
        word = word.replaceAll("O", "4");
        word = word.replaceAll("U", "5");
        
        int result = 0;
        int count = 10;
        while (!correntWord.toString().equals(word)) {
            result++;
            
            // 길이가 5가 아니라면 A를 계속 추가하기
            if (correntWord.length() < 5) {
                correntWord.append("1");
                continue;
            }
            
            // 단어 바꾸기
            char[] charArr = correntWord.toString().toCharArray();
            for (int i = 4; i >= 0; i--) {
                charArr[i] = (char) (charArr[i]+1);
                
                if (charArr[i] < '6') {
                    break;
                } else {
                    charArr[i] = '0';
                }
            }
            correntWord.setLength(0);
            
            for (int i = 0; i < 5; i++) {
                if (charArr[i] != '0') {
                    correntWord.append(charArr[i]);
                } else {
                    break;
                }
            }
        }
        
        return result;
    }
}