import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        long count = 0;
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                int target = A[i] + A[j];
                count += upperBound(j+1, A.length, -target) - lowerBound(j+1, A.length, -target) + 1;
            }
        }
        System.out.println(count);
    }

    private static int upperBound(int st, int en, int target) {
        int l = st, r = en, m = (l + r) / 2;
        while (l < r) {
            if (A[m] <= target) l = m+1;
            else if (A[m] > target) r = m;
            m = (l + r) / 2;
        }
        return m-1;
    }

    private static int lowerBound(int st, int en, int target) {
        int l = st, r = en, m = (l + r) / 2;
        while (l < r) {
            if (A[m] < target) l = m+1;
            else if (A[m] >= target) r = m;
            m = (l + r) / 2;
        }
        return m;
    }
}