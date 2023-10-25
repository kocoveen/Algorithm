class Solution {
    
    private int findMaxPalindrome(String s, int l, int r) {
        int L = l, R = r;
        
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        
        return R - L - 1;
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