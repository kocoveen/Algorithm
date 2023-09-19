import java.util.Arrays;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int A = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            A = gcd(A, arrayA[i]);
        }

        int B = arrayB[0];
        for (int i = 1; i < arrayB.length; i++) {
            B = gcd(B, arrayB[i]);
        }

        boolean flagA = indivisible(arrayB, A);
        boolean flagB = indivisible(arrayA, B);

        if (flagA && !flagB) {
            return A;
        } else if (!flagA && flagB) {
            return B;
        } else if (flagA && flagB) {
            return Math.max(A, B);
        } else {
            return 0;
        }
    }

    private boolean indivisible(int[] array, int gcd) {
        return Arrays.stream(array).noneMatch(i -> i >= gcd && i % gcd == 0);
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}