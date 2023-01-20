import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[][] board) {
        
        Set< List<Integer> > asd = new HashSet<>();
        
        for ( int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board[0].length; j++ ) {
                if (board[i][j] == 1) {
                    
                    for ( int k = i-1; k <= i+1; k++ ) {
                        for ( int l = j-1; l <= j+1; l++ ) {
                            if ( (k >= 0 && k < board.length) && (l >= 0 && l < board[0].length) ) {
                                List<Integer> warn = new ArrayList<>();
                                warn.add(k);
                                warn.add(l);
                                asd.add(warn);
                                System.out.printf("(%d, %d)\n", k, l);
                            }
                        }
                    }
                    
                }
            }
        }
        

        
        return board.length * board.length - asd.size();
        
    }
}