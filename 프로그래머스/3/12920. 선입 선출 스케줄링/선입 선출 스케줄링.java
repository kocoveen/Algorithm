class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        
        if (n <= cores.length) {
            return n;
        }
        
        int l = 0;
        int r = n * 10000;
        
        int T = lowerBound(l, r, n, cores); // 작업이 전부 할당되는 최소 시간 T
        
        int countT1 = count(T-1, cores); // T-1시간에 할당된 작업 수
        
        int remained = n - countT1; // T에 할당해야 할 남은 작업 수
        
        for (int i = 0; i < cores.length; i++) {
            if (T % cores[i] == 0) {
                remained--;
                if (remained == 0) {
                    answer = i+1;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    private int lowerBound(int l, int r, int n, int[] cores) {
        // int l = 0; int r = n * 10000;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (n <= count(m, cores)) r = m; // target과 같아도 계속 왼쪽으로 좁힘
            else l = m + 1;
        }
        return l;
    }
    
    private int count(int time, int[] cores) {
        int count = cores.length;
        for (int core : cores) {
            count += time / core;
        }
        return count;
    }
}