import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        
        for (int col : moves) {
            int row = 0;
            while(board[row][col-1] == 0) {
                if (row == board.length - 1)
                    break;
                row++;
            }
            if (board[board.length-1][col-1] == 0)
                continue;
            
            Integer c = Integer.valueOf(board[row][col-1]);
            basket.push(c);
            board[row][col-1] = 0;
            
            if(basket.size() < 2)
                continue;
            
            Integer top = basket.pop();
            if(top != basket.peek())
                basket.push(top);
            else {
                basket.pop();
                answer += 2;
            }
                
        }
        
        
        return answer;
    }
}