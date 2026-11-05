import java.util.*;

class Solution {
    int[][] pillars, beams;
    int N;

    public int[][] solution(int n, int[][] build_frame) {
        this.N = n;
        pillars = new int[n+1][n+1];
        beams = new int[n+1][n+1];

        for (int[] build : build_frame) {
            int c = build[0];
            int r = build[1];
            int obj = build[2];
            int cmd = build[3];

            if (cmd == 1) { // 설치
                if (obj == 0) pillars[r][c] = 1;
                else beams[r][c] = 1;

                if (!isValidAll()) {
                    if (obj == 0) pillars[r][c] = 0;
                    else beams[r][c] = 0;
                }
            } else { // 삭제
                if (obj == 0) pillars[r][c] = 0;
                else beams[r][c] = 0;

                if (!isValidAll()) {
                    if (obj == 0) pillars[r][c] = 1;
                    else beams[r][c] = 1;
                }
            }
        }

        List<int[]> answerList = new ArrayList<>();
        for (int c = 0; c <= n; c++) {
            for (int r = 0; r <= n; r++) {
                if (pillars[r][c] == 1) answerList.add(new int[]{c, r, 0});
                if (beams[r][c] == 1) answerList.add(new int[]{c, r, 1});
            }
        }

        answerList.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        return answerList.toArray(int[][]::new);
    }

    // 맵 전체를 스캔하며 규칙을 위반한 구조물이 단 하나라도 있는지 검사
    private boolean isValidAll() {
        for (int r = 0; r <= N; r++) {
            for (int c = 0; c <= N; c++) {
                if (pillars[r][c] == 1 && !isValidPillar(r, c)) return false;
                if (beams[r][c] == 1 && !isValidBeam(r, c)) return false;
            }
        }
        return true;
    }

    // (r, c) 위치의 기둥이 안전한지 검사
    private boolean isValidPillar(int r, int c) {
        if (r == 0) return true; // 바닥 위
        if (r-1 >= 0 && pillars[r-1][c] == 1) return true; // 아래에 기둥이 있음
        if (beams[r][c] == 1) return true; // 현재 위치에 보가 시작됨
        if (c-1 >= 0 && beams[r][c-1] == 1) return true; // 왼쪽에서 오는 보가 있음
        return false;
    }

    // (r, c) 위치의 보가 안전한지 검사
    private boolean isValidBeam(int r, int c) {
        if (r-1 >= 0 && pillars[r-1][c] == 1) return true; // 왼쪽 아래에 기둥이 있음
        if (r-1 >= 0 && pillars[r-1][c+1] == 1) return true; // 오른쪽 아래에 기둥이 있음
        if (c-1 >= 0 && beams[r][c-1] == 1 && beams[r][c+1] == 1) return true; // 양옆이 모두 보
        return false;
    }
}
