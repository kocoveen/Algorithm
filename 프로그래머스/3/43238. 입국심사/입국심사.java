import java.util.*;

//현재 시간을 기준으로 봤을때 몇 명이 최대로 마칠 수 있는가?

class Solution {
    
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long maxTime = (long) times[times.length - 1] * n;
        long minTime = 1;
        
        long l = minTime, r = maxTime;
        while (l < r) {
            long m = (l + r) / 2;
            if (getMaxComplete(m, times, n) < n) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        
        return l;
    }
    
    private long getMaxComplete(long target, int[] times, int n) {
        long maxComplete = 0;
        
        for (int t : times) {
            maxComplete += target / t;
            
            if (maxComplete >= n) {
                break;
            }
        }
        return maxComplete;
    }
}