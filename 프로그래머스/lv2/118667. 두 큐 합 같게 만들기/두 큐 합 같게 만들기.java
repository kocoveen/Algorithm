class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int len1 = queue1.length;
        int len2 = queue2.length;
        
        long[] q = new long[len1 + len2 + 1];
        
        for (int i = 1; i <= len1; i++) {
            q[i] = (long) q[i - 1] + queue1[i - 1];
        }
        
        for (int i = 1 + len1; i <= len1 + len2; i++) {
            q[i] = (long) q[i - 1] + queue2[i - len1 - 1];
        }
        
        // for (long i : q) {
        //     System.out.printf("[%d]", i);
        // }
        
        int f = 0, l = len1, count = 0; long target = q[len1 + len2] / 2;
        while (f < l && l <= len1 + len2) {
            if (q[l] - q[f] < target) {
                count++;
                l++;
            } else if (q[l] - q[f] > target) {
                count++;
                f++;
            } else {
                break;
            }
        }
        
        if (l == f || l > len1 + len2) {
            return -1;
        }
        return count;
    }
}