import java.io.*;
import java.util.Arrays;

public class Main {
    static String[] l;

    static long[] ans = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        l = br.readLine().split(" ");
        long[] A = new long[n];
        for (int i = 0; i < n; i++) A[i] = Long.parseLong(l[i]);

        Arrays.sort(A);

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                long target = A[i] + A[j];
                int idx = ternarySearch(A, j + 1, target);

                for (int k = -2; k <= 2; k++) {
                    if (idx + k == i || idx + k == j) continue;
                    if (idx + k < 0 || idx + k >= n) continue;
                    if (Math.abs(ans[0] + ans[1] + ans[2]) > Math.abs(A[i] + A[j] + A[idx + k])) {
                        ans[0] = A[i];
                        ans[1] = A[j];
                        ans[2] = A[idx + k];
                    }
                }
            }
        }

        for (long i : ans)
            System.out.printf("%d ", i);
    }

    private static int ternarySearch(long[] A, int st, long target) {
        int l = st, r = A.length - 1, p = (l * 2 + r) / 3, q = (l + r * 2) / 3;
        while (l < r) {
            if (Math.abs(target + A[p]) < Math.abs(target + A[q])) r = q;
            else l = p + 1;
            p = (l * 2 + r) / 3;
            q = (l + r * 2) / 3;
        }
        return p;
    }
}