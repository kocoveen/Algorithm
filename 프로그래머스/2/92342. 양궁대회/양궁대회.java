class Solution {
    
    static int maxDiff = -1; // 최대 점수 차이 (기본값 -1로 설정하여 이길 수 없는 경우 체크)
    static int[] maxArray = {-1}; // 정답이 없을 경우 -1 반환을 위한 초기화
    
    public int[] solution(int n, int[] info) {
        maxDiff = -1;
        maxArray = new int[]{-1};
        
        int[] lion = new int[11];
        dfs(0, n, lion, info);
        
        return maxArray;
    }
    
    // idx: 현재 확인 중인 과녁, left: 남은 화살 수
    private void dfs(int idx, int left, int[] lion, int[] apeach) {
        // 과녁을 다 돌았거나 남은 화살이 0개인 경우
        if (idx == 10 || left == 0) {
            lion[10] += left; // 남은 화살은 모두 가장 낮은 점수(0점)에 몰아줌
            calculateScore(lion, apeach);
            lion[10] -= left; // 백트래킹 복구
            return;
        }
        
        // 1. 현재 과녁(idx)에 어피치보다 1발 이상 더 맞히는 경우 (화살이 충분할 때만)
        // 어차피 얼마나 어피치보다 많이 쏘던 1발 이상만 더 맞히면 점수를 받음.
        if (left >= apeach[idx] + 1) {
            lion[idx] = apeach[idx] + 1;
            dfs(idx + 1, left - lion[idx], lion, apeach);
            lion[idx] = 0; // 백트래킹 복구
        }
        
        // 2. 현재 과녁(idx)에 화살을 0발 맞히고 넘어가는 경우
        dfs(idx + 1, left, lion, apeach);
    }
    
    // 점수 계산
    private void calculateScore(int[] lion, int[] apeach) {
        int lionScore = 0;
        int apeachScore = 0;
        
        for (int i = 0; i < 11; i++) {
            if (lion[i] == 0 && apeach[i] == 0) {
                continue;
            }
            if (lion[i] > apeach[i]) {
                lionScore += 10 - i;
            } else {
                apeachScore += 10 - i;
            }
        }
        
        int diff = lionScore - apeachScore;
        
        // 라이언이 이긴 경우에만 처리
        if (diff > 0) {
            if (diff > maxDiff) {
                maxDiff = diff;
                maxArray = lion.clone(); // 깊은 복사 필수!
            } else if (diff == maxDiff) {
                // 점수 차이가 같다면, 가장 낮은 점수(인덱스가 큰 쪽)를 더 많이 맞힌 경우로 갱신
                for (int i = 10; i >= 0; i--) {
                    if (lion[i] > maxArray[i]) {
                        maxArray = lion.clone();
                        break;
                    } else if (lion[i] < maxArray[i]) {
                        break;
                    }
                }
            }
        }
    }
}