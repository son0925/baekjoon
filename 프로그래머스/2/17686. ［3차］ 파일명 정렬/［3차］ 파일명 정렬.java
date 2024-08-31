import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        File[] fileArr = new File[files.length];
        int index = 0;
        for (String file : files) {
            fileArr[index++] = new File(file);
        }
        
        Arrays.sort(fileArr);  // File 클래스의 compareTo를 이용한 정렬
        
        String[] answer = new String[files.length];
        for (int i = 0; i < fileArr.length; i++) {
            answer[i] = fileArr[i].toString();
        }
        
        return answer;
    }
}

class File implements Comparable<File> {
    String head;
    String number;
    String tail;
    
    File(String file) {
        StringBuilder sbHead = new StringBuilder();
        StringBuilder sbNumber = new StringBuilder();
        StringBuilder sbTail = new StringBuilder();
        
        boolean isHead = true;
        boolean isNumber = true;
        for (char c : file.toCharArray()) {
            if (isHead) {
                if (Character.isDigit(c)) {
                    sbNumber.append(c);
                    isHead = false;
                } else {
                    sbHead.append(c);
                }
            } else if (isNumber) {
                if (Character.isDigit(c)) {
                    sbNumber.append(c);
                } else {
                    sbTail.append(c);
                    isNumber = false;
                }
            } else {
                sbTail.append(c);
            }
        }
        this.head = sbHead.toString();
        this.number = sbNumber.toString();
        this.tail = sbTail.toString();
    }
    
    @Override
    public String toString() {
        return head + number + tail;
    }
    
    @Override
    public int compareTo(File other) {
        // Head를 비교 (대소문자 구분 없이)
        int result = this.head.toLowerCase().compareTo(other.head.toLowerCase());
        
        // Head가 같으면 Number를 비교
        if (result == 0) {
            int thisNumber = Integer.parseInt(this.number);
            int otherNumber = Integer.parseInt(other.number);
            result = Integer.compare(thisNumber, otherNumber);
        }
        
        return result;
    }
}
