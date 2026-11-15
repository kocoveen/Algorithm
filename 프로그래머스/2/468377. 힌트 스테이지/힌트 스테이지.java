class Solution {
    
    int n;
    int[] hintCount;
    int hintCost;
    int totalCost = Integer.MAX_VALUE;
    
    int[][] cost;
    int[][] hint;
    int[][] dp;
    
    public int solution(int[][] cost, int[][] hint) {
        n = cost.length;        
        
        this.cost = cost;
        this.hint = hint;
        
        hintCount = new int[n]; // 0~n-1
        
        backtracking(0);
                
        return totalCost;
    }
    
    private void backtracking(int k) { // 어느 스테이지에서 힌트권 번들을 사는지, 그리고 얼마나 샀는지
        if (k == n-1) {
            // 계산
            int total = 0;
            for (int stage = 0; stage < n; stage++) {
                int count = Math.min(hintCount[stage], n-1);
                total += cost[stage][count];
            }
            
            totalCost = Math.min(totalCost, total + hintCost);
            return;
        }
        
        hintCost += hint[k][0];
        for (int i = 1; i < hint[k].length; i++) {
            hintCount[hint[k][i]-1]++;
        }
        backtracking(k+1);
        
        hintCost -= hint[k][0];
        for (int i = 1; i < hint[k].length; i++) {
            hintCount[hint[k][i]-1]--;
        }
        backtracking(k+1);
    }
}