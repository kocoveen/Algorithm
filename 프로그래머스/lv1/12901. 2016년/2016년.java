class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] monthDay = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] weekList = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int day = 0;
        
        for (int i = 0; i < a; i++) {
            day += monthDay[i];
        }
        day += b - 1;
        answer = weekList[day % 7];
        
        return answer;
    }
}