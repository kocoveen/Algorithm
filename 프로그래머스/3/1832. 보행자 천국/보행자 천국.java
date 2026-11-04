class Solution {
    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int[][] right = new int[m][n];
        int[][] down = new int[m][n];

        // 출발점은 이미 그 자리에 도달한 차량이 1대 있다고 가정합니다.
        right[0][0] = 1;
        down[0][0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                // 1. 왼쪽 칸(i, j-1)에서 오른쪽으로 진입하는 경우
                if (j > 0) {
                    int prev = cityMap[i][j-1];
                    if (prev == 0) {
                        right[i][j] = (right[i][j-1] + down[i][j-1]) % MOD;
                    } else if (prev == 1) {
                        right[i][j] = 0;
                    } else if (prev == 2) {
                        right[i][j] = right[i][j-1];
                    }
                }

                // 2. 위쪽 칸(i-1, j)에서 아래쪽으로 진입하는 경우
                if (i > 0) {
                    int prev = cityMap[i-1][j];
                    if (prev == 0) {
                        down[i][j] = (right[i-1][j] + down[i-1][j]) % MOD;
                    } else if (prev == 1) {
                        down[i][j] = 0;
                    } else if (prev == 2) {
                        down[i][j] = down[i-1][j];
                    }
                }
            }
        }

        return (right[m-1][n-1] + down[m-1][n-1]) % MOD;
    }
}