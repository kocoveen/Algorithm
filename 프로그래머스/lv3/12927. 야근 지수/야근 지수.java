import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int endIndex = works.length - 1;
        
        Arrays.sort(works);
        for (int i = 0; i < n; i++) {
            int index = findLowerIndexMaxBacklog(works, works[endIndex]);
            if (works[index] == 0) {
                continue;
            }
            works[index]--;
        }
        
        answer = evaluateMesure(works);
        
        return answer;
    }
    
    private int findLowerIndexMaxBacklog(int[] works, int target) {
        int l = 0, h = works.length, m;
        while (l < h) {
            m = (l + h) / 2;
            if (target <= works[m]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    
    private long evaluateMesure(int[] works) {
        long measure = 0;
        for (int i = 0; i < works.length; i++) {
            measure += works[i] * works[i];
        }
        return measure;
    }
}