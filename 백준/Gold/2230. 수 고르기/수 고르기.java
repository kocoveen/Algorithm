import java.io.*;
import java.util.Arrays;

public class Main {
    static String[] l;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        int n = Integer.parseInt(l[0]);
        int m = Integer.parseInt(l[1]);
        A = new int[n];
        for (int i = 0; i < n; i++) A[i] = Integer.parseInt(br.readLine());

        Arrays.sort(A);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int idx = lowerBound(A, i, m);
            if (idx == - 1) continue;
            min = Math.min(min, Math.abs(A[idx] - A[i]));
        }
        System.out.println(min);
    }

    private static int lowerBound(int[] A, int st, int target) {
        int l = st + 1, r = A.length, m = (l + r) / 2;
        while (l < r) {
            if (A[m] - A[st] < target) l = m + 1;
            else r = m;
            m = (l + r) / 2;
        }
        return (m >= A.length ? -1 : m);
    }

}