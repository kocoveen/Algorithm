import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack S = new Stack();
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                S.push('(');
            else {
                if (S.isEmpty()) return false;
                S.pop();
            } 
        }

        return S.isEmpty();
    }
}