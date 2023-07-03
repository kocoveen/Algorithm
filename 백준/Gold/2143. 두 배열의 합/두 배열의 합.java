import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static String[] l;
    static long cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] A, B, dpA, dpB;
        List<Integer> lstA, lstB;

        int n = Integer.parseInt(br.readLine());
        l = br.readLine().split(" ");
        A = new int[n + 1];
        dpA = new int[n + 1];
        lstA = new ArrayList<>();
        for (int i = 1; i <= n; i++) A[i] = Integer.parseInt(l[i - 1]);
        for (int i = 1; i <= n; i++) dpA[i] = dpA[i - 1] + A[i];

        int m = Integer.parseInt(br.readLine());
        l = br.readLine().split(" ");
        B = new int[m + 1];
        dpB = new int[m + 1];
        lstB = new ArrayList<>();
        for (int i = 1; i <= m; i++) B[i] = Integer.parseInt(l[i - 1]);
        for (int i = 1; i <= m; i++) dpB[i] = dpB[i - 1] + B[i];

        for (int i = 1; i <= n; i++)
            for (int j = 0; j < i; j++)
                lstA.add(dpA[i] - dpA[j]);

        for (int i = 1; i <= m; i++)
            for (int j = 0; j < i; j++)
                lstB.add(dpB[i] - dpB[j]);

        Collections.sort(lstA);
        Collections.sort(lstB);

        for (int item: lstA) {
            int target = T - item;
            int idx = upperBound(lstB, target) - lowerBound(lstB, target) + 1;
            if (idx < 1) continue;
            cnt += idx;
        }
        System.out.println(cnt);
    }

    private static int upperBound(List<Integer> lstB, int target) {
        int l = 0, r = lstB.size(), m = (l + r) / 2;
        while (l < r) {
            if (lstB.get(m) <= target) l = m + 1;
            else r = m;
            m = (l + r) / 2;
        }
        return m - 1;
    }

    private static int lowerBound(List<Integer> lstB, int target) {
        int l = 0, r = lstB.size(), m = (l + r) / 2;
        while (l < r) {
            if (lstB.get(m) < target) l = m + 1;
            else r = m;
            m = (l + r) / 2;
        }
        return m;
    }
}