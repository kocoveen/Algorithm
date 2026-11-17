class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        // 0번째 부터 시작
        
        // k번째 사다리꼴을 (삼각형, 우향 평행사변형, 마름모)로 채운 경우
        int[] P = new int[n]; // k번째 우하단 삼각형을 안 채운 경우
        
        // k번째 사다리꼴을 (좌향 평행사변형)로 채운 경우
        int[] Q = new int[n]; // k번째 우하단 삼각형을 채운 경우
        
        P[0] = tops[0] == 1 ? 3 : 2;
        Q[0] = 1;
        
        for (int i = 1; i < tops.length; i++) {
            if (tops[i] == 1) {
                P[i] = P[i-1] * 3 + Q[i-1] * 2;
                Q[i] = P[i-1] + Q[i-1];
            } else {
                P[i] = P[i-1] * 2 + Q[i-1];
                Q[i] = P[i-1] + Q[i-1];
            }
            
            P[i] %= 10007;
            Q[i] %= 10007;
        }
        
        return (P[n-1] + Q[n-1]) % 10007;
    }
}