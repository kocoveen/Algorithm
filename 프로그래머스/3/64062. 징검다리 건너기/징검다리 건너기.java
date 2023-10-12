class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int mx = findMaxStone(stones);
        
        int l = 0, r = mx;
        while (l < r) {
            int m = (l + r) / 2;
            if (findMaxDistance(stones, m) >= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        answer = l;
        
        return answer;
    }
    
    private int findMaxDistance(int[] stones, int k) {
        int mx = 0;
        int count = 0;
        for (int stone : stones) {
            if (stone <= k) {
                count++;
            } else {
                count = 0;
            }
            mx = Math.max(mx, count);
        }
        return mx;
    }
    
    private int findMaxStone(int[] stones) {
        int mx = 0;
        for (int stone : stones) {
            mx = Math.max(mx, stone);
        }
        return mx;
    }
}