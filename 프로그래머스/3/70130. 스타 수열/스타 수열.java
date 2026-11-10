import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        if (a.length < 2) {
            return answer;
        }
        
        int[] count = new int[a.length+1];
        for (int i = 0; i < a.length; i++) {
            count[a[i]]++;
        }
        
        for (int v = 0; v < count.length; v++) {
            // 현재 숫자의 빈도수 * 2가 이미 구한 answer보다 작거나 같다면 탐색할 필요 없음
            if (count[v] * 2 <= answer) {
                continue;
            }
            
            int c = 0; // v 일때 스타 수열의 개수
            for (int i = 0; i < a.length - 1;) {
                if (a[i] == a[i+1] || (a[i] != v && a[i+1] != v)) {
                    i++; // 다음 원소부터 탐색 (1칸 이동)
                    continue;
                }
                // 스타 수열의 조건을 만족하는 한 쌍을 찾은 경우
                c++;
                i += 2; // 두 원소를 사용(2칸 이동)
            }
            
            answer = Math.max(answer, c*2);
        }
        return answer;
    }
}