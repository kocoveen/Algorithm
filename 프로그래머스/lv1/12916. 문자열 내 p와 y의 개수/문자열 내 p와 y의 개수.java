class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            String a = s.substring(i, i+1);
            if (a.toLowerCase().equals("p")) {
                cnt += 1;
            }
            
            if (a.toLowerCase().equals("y")) {
                cnt -= 1;
            }
        }
        
        if (cnt != 0) {
            return false;
        }

        return answer;
    }
}