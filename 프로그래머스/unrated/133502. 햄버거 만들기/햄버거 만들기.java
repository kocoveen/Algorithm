import java.util.*;

class Solution {
    static int cnt;
    
    public int solution(int[] ingredient) {
        Stack<Integer> S = new Stack();
        
        for(int i : ingredient) {
            S.push(i);
            if (S.size() < 4) continue;
            if (isBurger(S)) {
                cnt++;
                S.pop();
                S.pop();
                S.pop();
                S.pop();
            }
        }
        return cnt;
    }
    
    public boolean isBurger(Stack<Integer> S) {
        return S.elementAt(S.size() - 1) == 1 &&
            S.elementAt(S.size() - 2) == 3 &&
            S.elementAt(S.size() - 3) == 2 &&
            S.elementAt(S.size() - 4) == 1;
    }
}