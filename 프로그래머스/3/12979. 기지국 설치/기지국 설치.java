class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int l = 0;
        for (int station : stations) {
            int st = station - w - 1;
            int en = station + w - 1;
            
            if (st > l) {
                answer += (st - l - 1) / (w * 2 + 1) + 1;
            }
            l = en + 1;
        }
        
        if (n > l) {
            answer += (n - l - 1) / (w * 2 + 1) + 1;
        }

        return answer;
    }
}