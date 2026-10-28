import java.util.*;

class Solution {
    // 시간(time), 행(r), 열(c)
    record Log(int time, int r, int c) {}

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        // 각 시간대별 좌표에 위치한 로봇의 수를 기록하는 Map
        Map<Log, Integer> timeMap = new HashMap<>();
        
        for (int i = 0; i < routes.length; i++) {
            int time = 0;
            
            // 0초 시점의 시작 위치 설정 (1번 인덱스를 0번 인덱스로 보정)
            int startPointIdx = routes[i][0] - 1;
            int curR = points[startPointIdx][0];
            int curC = points[startPointIdx][1];
            
            // 0초일 때의 위치 기록
            timeMap.merge(new Log(time, curR, curC), 1, Integer::sum);
            
            // 이후 경유지들을 순서대로 방문
            for (int j = 1; j < routes[i].length; j++) {
                int nextPointIdx = routes[i][j] - 1;
                int targetR = points[nextPointIdx][0];
                int targetC = points[nextPointIdx][1];
                
                // 1. r 좌표 조건에 맞춰 이동
                while (curR != targetR) {
                    if (curR < targetR) curR++;
                    else curR--;
                    
                    time++;
                    timeMap.merge(new Log(time, curR, curC), 1, Integer::sum);
                }
                
                // 2. c 좌표 조건에 맞춰 이동
                while (curC != targetC) {
                    if (curC < targetC) curC++;
                    else curC--;
                    
                    time++;
                    timeMap.merge(new Log(time, curR, curC), 1, Integer::sum);
                }
            }
        }
        
        // 2대 이상의 로봇이 겹친 상황(Value가 2 이상)의 개수를 카운트
        for (int count : timeMap.values()) {
            if (count > 1) {
                answer++;
            }
        }
        
        return answer;
    }
}
