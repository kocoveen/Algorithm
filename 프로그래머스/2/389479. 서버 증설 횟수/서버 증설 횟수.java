class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int actived_server = 0;
        int[] servers = new int[24];
        for (int i = 0; i < 24; i++) {
            if (i >= k) {
                actived_server -= servers[i - k];
            }
            
            int required = players[i] / m;
            if (required > actived_server) {
                int add = required - actived_server;
                answer += add;
                actived_server += add;
                servers[i] = add;
            }
        }
        return answer;
    }
}