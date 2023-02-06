class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();
        
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p')
                cnt++;
            else if (s.charAt(i) == 'y')
                cnt--;
        }
        
        if (cnt != 0) {
            return false;
        }

        return answer;
    }
}