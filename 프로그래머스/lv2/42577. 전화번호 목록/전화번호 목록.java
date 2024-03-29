import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Map<String, String> map = new HashMap<>();
        
        for (String s : phone_book) {
            map.put(s, s);
        }
        
        for (String s : phone_book) {
            for (int i = 1; i < s.length(); i++) {
                if (map.containsKey(s.substring(0, i))) {
                    return false;
                }
            }
        }
        
        return answer;
    }
}