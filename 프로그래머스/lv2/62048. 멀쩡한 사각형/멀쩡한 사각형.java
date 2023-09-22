class Solution {
    public long solution(long w, long h) {
        long answer = 1;
        
        long a = gcd(w, h);
        long ww = w / a;
        long hh = h / a;
        
        long cut = ww + hh - 1; //((ww * hh) - (ww - 1) * (hh - 1))
        
        answer = (w * h) - cut * a;
        return answer;
    }
    
    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}