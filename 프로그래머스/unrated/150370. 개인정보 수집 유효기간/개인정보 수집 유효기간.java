import java.util.*;

class Solution {
    
    static int cnt;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = new int[105];
        
        Map<String, Integer> termsMap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            termsMap.put(term[0], Integer.parseInt(term[1]));
        }
        
        int date = getDate(today);
        
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            int expireDate = getDate(privacy[0]) + 28 * termsMap.get(privacy[1]);
            
            if (date >= expireDate) {
                answer[cnt++] = i + 1;
            }
        }
        
        int[] ans = new int[cnt];
        for (int i = 0; i < cnt; i++) ans[i] = answer[i];

        return ans;
    }
    
    private int getDate(String date) {
        String[] YMD = date.split("\\.");
        int year = Integer.parseInt(YMD[0]);
        int month = Integer.parseInt(YMD[1]);
        int day = Integer.parseInt(YMD[2]);
        return year * 12 * 28 + month * 28 + day;
    }
}