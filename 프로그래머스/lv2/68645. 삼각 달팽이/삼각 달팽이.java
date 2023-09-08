class Solution {

    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];

        int[][] tmp = fillArr(n);
        
        int idx = 0;
        for (int[] a : tmp) {
            for (int i : a) {
                if (i == 0) continue;
                answer[idx++] = i;
            }
        }

        return answer;
    }

    public int[][] fillArr(int n) {
        int[][] tmp = new int[n][n];
        
        int count = 1, r = -1, c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    r++;
                } else if (i % 3 == 1) {
                    c++;
                } else {
                    r--;
                    c--;
                }
                tmp[r][c] = count++;
            }
        }
        return tmp;
    }
}