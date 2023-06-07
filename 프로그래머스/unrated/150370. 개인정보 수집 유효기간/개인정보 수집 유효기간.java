import java.util.*;

class Solution {
    
    static int cnt, aday;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = new int[105];
        
        Map<String, Integer> termsMap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            termsMap.put(term[0], Integer.parseInt(term[1]));
        }
        
        String[] date = today.split("\\W");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        aday = year * 10000 + month * 100 + day;
        
        for (int i = 0; i < privacies.length; i++) {
            date = privacies[i].split("\\W");
            
            int tmpMonth = Integer.parseInt(date[1]) + termsMap.get(date[3]);
            
            year = Integer.parseInt(date[0]) + (tmpMonth - 1) / 12;
            month = (tmpMonth - 1) % 12 + 1;
            day = Integer.parseInt(date[2]);
            
            int expiration = year * 10000 + month * 100 + day;
            
            if (aday >= year * 10000 + month * 100 + day) {
                answer[cnt] = i + 1;
                cnt++;
            }
        }
        
        int[] ans = new int[cnt];
        for (int i = 0; i < cnt; i++) ans[i] = answer[i];

        return ans;
    }
}