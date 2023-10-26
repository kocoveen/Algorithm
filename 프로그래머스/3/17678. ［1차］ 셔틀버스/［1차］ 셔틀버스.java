import java.util.*;
 
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String time : timetable) { // 크루들을 우선순위 큐에 오름차순으로
            pq.add(timeToInt(time));
        }
     
        int start_time = 9 * 60, last_time = 0; // 버스 출발 시각은 9시
        int total = 0; 
        for(int i = 0; i < n; i++) {
            total = 0; // 현재 온 버스에 탄 크루
            while (!pq.isEmpty()) {
                int current_time = pq.peek();
                if (current_time <= start_time && total < m) { // 만약 버스 출발 시간 이전에 기다린 크루가 있거나, 버스가 만석이 아니면
                    pq.poll();
                    total++;
                } else {
                    break;
                }
                last_time = current_time - 1; // 버스를 탄 크루의 시간 - 1 을 버스에 마지막으로 탄 시간으로
            }
            start_time += t;
        }
        
        // 마지막 버스에 탄 사람 수 < m 일 때의 상황 -> 마지막 버스를 타면 됨.
        if (total < m) {
            last_time = start_time - t;
        }
        
        return intToTime(last_time);
    }
    
    private int timeToInt(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
    }
    
    private String intToTime(int i) {
        return String.format("%02d:%02d", i / 60, i % 60);
    }
}
