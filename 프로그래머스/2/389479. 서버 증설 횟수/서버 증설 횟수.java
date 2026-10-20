class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[24 + k];
        for (int i = 0; i < 24; i++) {
            // 만약 현재 있는 서버로 감당이 안되면 빌리기
            int needed_server = (players[i] / m) - servers[i] < 0 ? 0 : (players[i] / m) - servers[i];
            for (int j = 0; j < k; j++) {
                servers[i + j] += needed_server;
            }
            answer += needed_server;
        }
        return answer;
    }
}