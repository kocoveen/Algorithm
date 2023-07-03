import java.io.*;
import java.util.Arrays;

public class Main {
    static String[] l;

    static long[] ans = new long[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        l = br.readLine().split(" ");
        long[] A = new long[n];
        for (int i = 0; i < n; i++) A[i] = Long.parseLong(l[i]);

        Arrays.sort(A);

        long diff = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;

            while(left < right) {
                long sum = A[i] + A[left] + A[right];
                long cur_diff = Math.abs(sum);
                if (diff > cur_diff) {
                    diff = cur_diff;
                    ans[0] = A[i];
                    ans[1] = A[left];
                    ans[2] = A[right];
                }

                if(sum > 0) right--;
                else left++;
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