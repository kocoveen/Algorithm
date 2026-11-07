class Solution {
    
    boolean[] visited;
    int[] list; // 현재 선택된 친구들의 순서(순열)를 저장할 배열
    int minResult;
    
    int[] extendedWeak; // 외벽 점검을 위해 2배로 직선화한 취약 지점 배열
    int weakLen; // 원래 weak의 길이

    public int solution(int n, int[] weak, int[] dist) {
        weakLen = weak.length;
        minResult = dist.length + 1;
        
        visited = new boolean[dist.length];
        list = new int[dist.length];
        
        extendedWeak = new int[weakLen * 2];
        for (int i = 0; i < weakLen; i++) {
            extendedWeak[i] = weak[i];
            extendedWeak[i + weakLen] = weak[i] + n;
        }
        
        permutation(dist.length, 0, dist);
        
        return minResult > dist.length ? -1 : minResult;
    }
    
    private void permutation(int len, int k, int[] dist) {
        if (len == k) {
            count();
            return;
        }
        
        for (int i = 0; i < len; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            list[k] = dist[i];
            permutation(len, k + 1, dist);
            visited[i] = false;
        }
    }
    
    private void count() {
        for (int start = 0; start < weakLen; start++) {
            int friendCount = 1; // 투입된 친구 수
            int position = extendedWeak[start] + list[friendCount - 1];
            
            for (int index = start; index < start + weakLen; index++) {
                if (position < extendedWeak[index]) {
                    friendCount++; // 다음 친구 투입
                    
                    if (friendCount > list.length) {
                        break;
                    }
                    
                    position = extendedWeak[index] + list[friendCount - 1];
                }
            }
            
            if (friendCount <= list.length) {
                minResult = Math.min(minResult, friendCount);
            }
        }
    }
}