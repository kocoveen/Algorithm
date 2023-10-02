class Solution {
    int[][] board;
    
    public int solution(int n) {
        board = new int[n][n];
        
        int answer = func(0, n);
        return answer;
    }
    
    private int func(int r, int n) {
        int sum = 0;
        if (r == n) {
            // print(board);
            return 1;
        }
        
        
        for (int c = 0; c < n; c++) {
            if (!isPossible(r, c, n)) continue;
            board[r][c] = 1;
            sum += func(r + 1, n);
            board[r][c] = 0;
        }
        return sum;
    }
    
    private boolean isPossible(int r, int c, int n) {
        //세로
        for (int i = 0; i < n; i++) {
            if (i == r) continue;
            if (board[i][c] == 1) {
                return false;
            }
        }
        
        // '\' 대각선
        for (int i = r - c, j = 0; j < n; i++, j++) {
            if (i == r || i < 0 || i >= n) continue;
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        // '/' 대각선
        for (int i = r + c, j = 0; j < n; i--, j++) {
            if (i == r || i < 0 || i >= n) continue;
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        return true;
    }
    
    private void print(int[][] board) {
        for (int[] b : board) {
            for (int i : b) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
        System.out.println();
    }
}