class Solution {
    public int solution(int[] stones, int k) {
        int l = 0, r = 200000000;
        while (l < r) {
            int m = (l + r) / 2;
            if (canCross(stones, m, k)) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
    
    private boolean canCross(int[] stones, int m, int k) {
        int count = 0;
        for (int stone : stones) {
            if (stone <= m) {
                count++;
                if (count == k) {
                    return false;
                }
            } else {
                count = 0;
            }
        }
        return true;
    }
}