class Solution {
    
    private int findMaxPalindrome(String s, int l, int r) {        
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        
        return r - l - 1;
    }
       
    public int solution(String s) {
        int answer = 1;
        
        for (int i = 0; i < s.length(); i++) {
            answer = Math.max(answer, findMaxPalindrome(s, i, i));
            answer = Math.max(answer, findMaxPalindrome(s, i, i + 1));
        }

        return answer;
    }
}