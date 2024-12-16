class Solution {
    static int m, n, pn;

    public boolean solution(int[][] key, int[][] lock) {
        m = key.length; // (m <= n)
        n = lock.length;
        pn = (m - 1) * 2 + n; // 새로운 자물쇠 길이

        int[][] pLock = new int[pn][pn];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pLock[i + m - 1][j + m - 1] = lock[i][j];
            }
        }

        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < m + n - 1; i++) {
                for (int j = 0; j < m + n - 1; j++) {
                    if (isUnlocked(i, j, key, pLock)) {
                        return true;
                    }
                }
            }
            key = rotate(key);
        }
        return false;
    }
    
    // key 90도 회전
    private int[][] rotate(int[][] key) {
        int[][] newKey = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                newKey[j][m - 1 - i] = key[i][j];
            }
        }
        return newKey;
    }

    // key 와 padding 한 lock 이 전부 맞는지
    private boolean isUnlocked(int i, int j, int[][] key, int[][] pLock) {
        int[][] newLock = makeNewLock(pLock);

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < m; c++) {
                newLock[i + r][j + c] ^= key[r][c]; // XOR 연산
            }
        }

        return isFitted(newLock);
    }

    // newLock 의 lock 부분이 전부 1인지
    private boolean isFitted(int[][] newLock) { 
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (newLock[m - 1 + r][m - 1 + c] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // pLock 복사
    private int[][] makeNewLock(int[][] pLock) {
        int[][] tmp = new int[pn][pn];
        for (int i = 0; i < pn; i++) {
            for (int j = 0; j < pn; j++) {
                tmp[i][j] = pLock[i][j];
            }
        }
        return tmp;
    }
}