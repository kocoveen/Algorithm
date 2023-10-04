import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = -1;
        
        List<Pair> O = new ArrayList<>();
        List<Pair> X = new ArrayList<>();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'O') {
                    O.add(new Pair(i, j));
                } else if (board[i].charAt(j) == 'X') {
                    X.add(new Pair(i, j));
                }
            }
        }
        
        if (O.size() != X.size() && O.size() - 1 != X.size()) {
            return 0;
        }
        
        if (isWon(O)) {
            if (isWon(X) || X.size() == O.size()) {
                return 0;
            }
            return 1;
            
        } else {
            if (isWon(X) && X.size() != O.size()) {
                return 0;
            }
            return 1;
        }
    }
    
    private boolean isWon(List<Pair> pairs) {
        List<List<Pair>> lines = new ArrayList<>();
        
        // 6 -> \, 7 -> /
        for (int i = 0; i < 8; i++) {
            lines.add(new ArrayList<>());
        }
        
        for (Pair p : pairs) {
            lines.get(p.r).add(p);
            lines.get(p.c + 3).add(p);
            if (p.r == p.c) {
                lines.get(6).add(p);
            }
            
            if (p.r + p.c == 2) {
                lines.get(7).add(p);
            }
        }
            
        for (List<Pair> line : lines) {
            if (line.size() == 3) {
                return true;
            }
        }
    
        return false;
    }
    
    static class Pair {
        int r;
        int c;
        
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}