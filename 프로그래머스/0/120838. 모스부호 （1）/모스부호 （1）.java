import java.util.*;

class Solution {
    public String solution(String letter) {
        HashMap<String,String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        String[] morseArr = {
            ".- a", "-... b", "-.-. c", "-.. d", ". e", "..-. f",
            "--. g", ".... h", ".. i", ".--- j", "-.- k", ".-.. l",
            "-- m", "-. n", "--- o", ".--. p", "--.- q", ".-. r",
            "... s", "- t", "..- u", "...- v", ".-- w", "-..- x",
            "-.-- y", "--.. z"
        };
        for (String morse : morseArr) {
            String[] splitMorse = morse.split(" ");
            String key = splitMorse[0];
            String value = splitMorse[1];
            map.put(key, value);
        }
        
        for (String s : letter.split(" ")) {
            sb.append(map.get(s));
        }
        
        
        return sb.toString();
    }
}