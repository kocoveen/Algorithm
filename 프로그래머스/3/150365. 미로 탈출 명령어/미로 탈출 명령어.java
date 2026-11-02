import java.util.*;

class Solution {
    // 사전 순 정렬: d (아래), l (왼쪽), r (오른쪽), u (위)
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static char[] direction = {'d', 'l', 'r', 'u'};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        // 1. 시작점에서 목적지까지 최단 거리 계산
        int minDist = Math.abs(x - r) + Math.abs(y - c);
        
        // 2. 탈출이 불가능한 경우 예외 처리
        // 최단 거리가 k보다 크거나, 남은 거리가 홀수인 경우 (이동 횟수가 맞지 않음)
        if (minDist > k || (k - minDist) % 2 == 1) {
            return "impossible";
        }

        StringBuilder sb = new StringBuilder();
        int curX = x;
        int curY = y;

        // 3. 매 단계마다 d -> l -> r -> u 순서로 이동
        for (int step = 0; step < k; step++) {
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                // 격자 범위를 벗어나면 패스
                if (nx < 1 || nx > n || ny < 1 || ny > m) continue;

                // 다음 칸에서 목적지까지의 최단 거리
                int nextDist = Math.abs(nx - r) + Math.abs(ny - c);
                // 남은 이동 횟수 (k - 현재까지 이동한 횟수 - 1)
                int remainStep = k - step - 1;

                // 이동할 수 있는 조건 만족 시 (최단 거리가 남은 걸음 수 이하)
                if (nextDist <= remainStep) {
                    sb.append(direction[i]);
                    curX = nx;
                    curY = ny;
                    break; // 찾았으므로 다음 step으로 넘어감 (사전순 최우선 선택 완료)
                }
            }
        }

        return sb.toString();
    }
}
