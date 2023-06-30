import java.io.*;
import java.util.Arrays;

public class Main {
    static String[] l;
    static int[] A;
    static int cnt, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        A = new int[n];
        l = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            A[i] = Integer.parseInt(l[i]);

        Arrays.sort(A);

        for (int i = 0; i < n; i++) solve(i);
        System.out.println(cnt);
    }

    private static void solve(int i) {
        for (int j = 0; j < n; j++) {
            if(j == i) continue;
            int target = A[i] - A[j];
            int idx = lowerBound(A, target);

            while (idx < n && A[idx] == target) {
                if (idx != i && idx != j) {
                    cnt++;
                    return;
                }
                idx++;
            }
        }
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
}