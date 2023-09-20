class Solution
{
    public int solution(int[][] board)
    {
        int answer = 0;
        
        int[][] tmp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                tmp[i][j] = board[i][j];
            }
        }
        
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] == 0 || 
                    board[i][j - 1] == 0 ||
                    board[i - 1][j] == 0 ||
                    board[i - 1][j - 1] == 0) continue;
                
                int v = Math.min(Math.min(tmp[i-1][j], tmp[i-1][j-1]), tmp[i][j-1]);
                int k = (int) Math.sqrt(v) + 1;
                tmp[i][j] = k * k;
            }
        }
        
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {
                // System.out.printf("%d ", tmp[i][j]);
                answer = Math.max(answer, tmp[i][j]);
            }
            // System.out.println();
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println(answer);

        return answer;
    }
}