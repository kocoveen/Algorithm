import java.util.*;

class Solution {
    
    static List<Set<Integer>> setList;
    static int answer;
    
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        setList = new ArrayList<>();
        
        for (int i = 0; i < q.length; i++) {
            setList.add(new HashSet<>());
        }
        
        for (int i = 0; i < q.length; i++) {
            Set<Integer> set = setList.get(i);
            for (int j = 0; j < q[i].length; j++) {
                set.add(q[i][j]);
            }
        }
        
        seek(n, 0, 1, new HashSet<Integer>(), ans);
        
        return answer;
    }
    
    private void seek(int n, int k, int s, Set<Integer> A, int[] ans) {
        if (k == 5) {
            for (int i = 0; i < ans.length; i++) {
                // 원본유지를 위해 복사본 생성
                Set<Integer> B = setList.get(i);

                int c = 0;
                for (int num : A) {
                    if (B.contains(num)) {
                        c++;
                    }
                }
                
                if (c != ans[i]) {
                    return;
                }
            }
            answer++;
            return;
        }
        
        for (int i = s; i <= n; i++) {
            A.add(i);
            seek(n, k+1, i+1, A, ans);
            A.remove(i);
        }
        
    }
}