class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = toSeconds(play_time);
        int advTime = toSeconds(adv_time);
        
        long[] totalTime = new long[playTime + 1]; // 누적합으로 +1 해줌
        
        // 시작, 끝에 +1, -1
        for (String log : logs) {
            String[] split = log.split("-");
            int startTime = toSeconds(split[0]);
            int endTime = toSeconds(split[1]);
            totalTime[startTime]++;
            totalTime[endTime]--;
        }
        
        // 누적합으로 현재 시간의 시청자 수 구함
        for (int i = 1; i <= playTime; i++) {
            totalTime[i] += totalTime[i-1];
        }
        
        // 2차 누적합. 광고 길이로 계속 전부 더할 수 없으니 더해서 끝 값만 찾기
        for (int i = 1; i <= playTime; i++) {
            totalTime[i] += totalTime[i-1];
        }
        
        // 슬라이딩 윈도우로 광고를 넣었을 때 누적 시청 시간이 최대가 되는 시작점 찾기
        // 초기값: 0초에 광고를 시작했을 때 누적합 [0, advTime-1]
        long maxVolume = totalTime[advTime - 1];
        int maxStartTime = 0;
        
        // 광고 창을 1초씩 뒤로 밀며 확인
        for (int start = 1; start <= playTime - advTime; start++) {
            int end = start + advTime - 1;
            // 구간 [start, end]의 누적합
            long currentVolume = totalTime[end] - totalTime[start - 1];
            
            if (currentVolume > maxVolume) {
                maxVolume = currentVolume;
                maxStartTime = start;
            }
        }
        
        return toTimeString(maxStartTime);
    }
    
    private int toSeconds(String timeString) {
        String[] split = timeString.split(":");
        int h = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int s = Integer.parseInt(split[2]);
        return h * 3600 + m * 60 + s;
    }
    
    private String toTimeString(int totalSeconds) {
        int h = totalSeconds / 3600;
        int m = (totalSeconds % 3600) / 60;
        int s = totalSeconds % 60;
        return "%02d:%02d:%02d".formatted(h, m, s);
    }
}