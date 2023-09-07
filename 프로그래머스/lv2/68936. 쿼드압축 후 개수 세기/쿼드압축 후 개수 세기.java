class Solution {
    int o = 0;
    int z = 0;
    public int[] solution(int[][] arr) {
        int q = arr.length;

        func(arr, 0, 0, q);
        return new int[]{z, o};
    }

    private void func(int[][] arr, int stR, int stC, int size) {
        if (size == 1 || isSameBlock(arr, stR, stC, size)) {
            if (arr[stR][stC] == 1) {
                o++;
            } else {
                z++;
            }
            return;
        }

        int newSize = size / 2;

        func(arr, stR, stC, newSize);
        func(arr, stR + newSize, stC, newSize);
        func(arr, stR, stC + newSize, newSize);
        func(arr, stR + newSize, stC + newSize, newSize);
    }

    private static boolean isSameBlock(int[][] arr, int stR, int stC, int size) {
        for (int i = stR; i < stR + size; i++) {
            for (int j = stC; j < stC + size; j++) {
                if (arr[stR][stC] != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}