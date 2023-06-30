import java.io.*;
import java.util.Arrays;

public class Main {
    static String[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        boolean[] chk = new boolean[n];
        l = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            A[i] = Integer.parseInt(l[i]);

        Arrays.sort(A);

        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int target = A[i] + A[j];
                int l = lowerBound(A, target);
                int r = upperBound(A, target);

                if (r < l) continue;

                for (int k = l; k <= r; k++) {
                    if (k == i || k == j || chk[k]) continue;
                    chk[k] = true;
                }
            }
        }

        for (int i = 0; i < n; i++)
            if (chk[i]) cnt++;

        System.out.println(cnt);
    }

    private static int lowerBound(int[] A, int target) {
        int l = 0, r = A.length, m = (l + r) / 2;
        while (l < r) {
            if (target <= A[m]) r = m;
            else l = m + 1;
            m = (l + r) / 2;
        }
        return m;
    }

    private static int upperBound(int[] A, int target) {
        int l = 0, r = A.length, m = (l + r) / 2;
        while (l < r) {
            if (target < A[m]) r = m;
            else l = m + 1;
            m = (l + r) / 2;
        }
        return m - 1;
    }

}