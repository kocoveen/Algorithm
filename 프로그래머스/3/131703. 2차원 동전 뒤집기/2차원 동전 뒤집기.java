class Solution {
    
    int R, C;
    int min = Integer.MAX_VALUE;
    int[][] beginning, target;
    
    public int solution(int[][] beginning, int[][] target) {
        this.R = target.length;
        this.C = target[0].length;
        this.beginning = beginning;
        this.target = target;
        
        backtracking(0, new int[R], 0);
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    private void backtracking(int k, int[] flip, int rowFlipCount) {
        if (k == R) {
            int colFlipCount = getColFlipCount(flip);
            if (colFlipCount != -1) {
                min = Math.min(min, rowFlipCount + colFlipCount);
            }
            return;
        }
        
        flip[k] = 0; // k번째 행을 뒤집지 않음
        backtracking(k + 1, flip, rowFlipCount);
        
        flip[k] = 1; // k번째 행을 뒤집음
        backtracking(k + 1, flip, rowFlipCount + 1);
    }
    
    // 결정된 행 뒤집기(flip) 상태에서 각 열(j)을 몇 번 뒤집어야 하는지 계산
    private int getColFlipCount(int[] flip) {
        int colCount = 0;
        
        for (int j = 0; j < C; j++) {
            int diffCount = 0; // j번째 열에서 target과 다른 칸의 개수
            
            for (int i = 0; i < R; i++) {
                // 행을 뒤집은 결과와 target이 다르면 카운트 증가
                if ((beginning[i][j] ^ flip[i]) != target[i][j]) {
                    diffCount++;
                }
            }
            
            if (diffCount == 0) {
                // 모든 행이 이미 일치함 -> 이 열은 뒤집을 필요 없음
                continue;
            } else if (diffCount == R) {
                // 모든 행이 정반대임 -> 이 열을 1번 뒤집으면 모두 일치함
                colCount++;
            } else {
                // 일부만 일치하고 일부는 다름 -> 열을 뒤집어도 target을 만들 수 없음
                return -1;
            }
        }
        
        return colCount;
    }
}
