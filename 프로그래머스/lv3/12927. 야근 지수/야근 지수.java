import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int endIndex = works.length - 1;

        Arrays.sort(works);
        for (int i = 0; i < n; i++) {
            // target(works 중 가장 큰 값)의 lowerBound 찾기            
            int index = findMaxWorkLowerBound(works, works[endIndex]);
            
            // 가장 큰 값이 0 이면 continue;
            if (works[index] == 0) { 
                continue;
            }
            
            // 가장 큰 값이 0이 아니면 그 값 1 빼기
            works[index]--;
        }

        // 야근 지수 구하기
        answer = evaluateMesure(works);
        return answer;
    }

    private int findMaxWorkLowerBound(int[] works, int target) {
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