import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            list.add(B[i]);
        }
        Collections.sort(list);
        
        
        for (int i = 0; i < A.length; i++) {
            int l = 0, r = list.size(), target = A[i], dest = 0;
            while(l < r) {
                int mid = (l + r) / 2;
                if (target + 1 <= list.get(mid)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
                dest = l;
            }
            
            if (list.size() == dest) {
                continue;
            }
            list.remove(dest);
            answer++;
        }
        
        return answer;
    }
}