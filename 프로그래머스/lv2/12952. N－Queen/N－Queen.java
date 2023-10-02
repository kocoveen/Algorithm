class Solution {
    int[][] board;
    int answer = 0;
    
    public int solution(int n) {
        
        board = new int[n][n];
        func(0, n);
        return answer;
    }
    
    private void func(int r, int n) {
        if (r == n) {
            answer++;
            // print(board);
            return;
        }
        
        
        for (int c = 0; c < n; c++) {
            if (!isPossible(r, c, n)) continue;
            board[r][c] = 1;
            func(r + 1, n);
            board[r][c] = 0;
        }
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