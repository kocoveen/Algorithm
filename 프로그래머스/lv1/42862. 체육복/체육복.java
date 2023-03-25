import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n];

        Arrays.fill(students, 1);
        
        for (int i : lost) {
            students[i-1]--;
        }
        
        for (int i : reserve) {
            students[i-1]++;
        }
        
        for (int i = 0; i < n; i++) {
            if (students[i] == 2) {
                if(i > 0 && students[i-1] == 0) {
                    students[i-1]++;
                    students[i]--;
                } else if (i < n -1 && students[i+1] == 0) {
                    students[i+1]++;
                    students[i]--;
                }
            }
        }
        
        for (int i : students) {
            if (i >= 1) {
                answer++;
            }
        }
        
        return answer;
    }
}