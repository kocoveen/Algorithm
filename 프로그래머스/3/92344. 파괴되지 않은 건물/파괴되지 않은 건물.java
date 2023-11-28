class Solution {
    public int solution(int[][] board, int[][] skills) {
        int answer = 0;
        int row = board.length;
        int col = board[0].length;
        
        // 누적합을 위한 acc 배열
        int[][] acc = new int[row + 1][col + 1];
        
        for (int[] skill : skills) {
            int type = skill[0];
            int r1 = skill[1]; int c1 = skill[2];
            int r2 = skill[3]; int c2 = skill[4];
            int deg = skill[0] != 1 ? skill[5] : -skill[5];
            
            acc[r1][c1] += deg; //leftTop
            acc[r1][c2+1] -= deg; //rightTop
            acc[r2+1][c1] -= deg; //leftBottom
            acc[r2+1][c2+1] += deg; //rightBottom
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                acc[i][j+1] += acc[i][j];
            }
        }
        
        // +col 방향으로 누적합
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                acc[i+1][j] += acc[i][j];
            }
        }
        
        // +row 방향으로 누적합
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] += acc[i][j];
                if (board[i][j] > 0) {
                    answer++;
                }
            }            
        }
        
        return answer;
    }
}