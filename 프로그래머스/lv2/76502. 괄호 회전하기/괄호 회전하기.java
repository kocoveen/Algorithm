import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
                
        for (int i = 0; i < s.length(); i++) {
            if (correct(s)) answer++;
            s = s.substring(1, s.length()) + s.substring(0, 1);
        }
        
        return answer;
    }
    
    private boolean correct(String s) {
        Stack<Character> S = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLeftBracket(c)) {
                S.push(c);
            }
            else {
                if (S.isEmpty()) return false;
                char d = S.peek();
                if (!isPairBracket(d, c)) {
                    return false;
                }
                S.pop();
            }
        }
        
        return S.isEmpty() ? true : false;
    }
    
    private boolean isLeftBracket(char c) {
        return c == '[' || c == '(' || c == '{';
    }
    
    private boolean isPairBracket(char d, char c) {
        return (d == '[' && c == ']') || (d == '(' && c == ')') || (d == '{' && c == '}');
    }
}