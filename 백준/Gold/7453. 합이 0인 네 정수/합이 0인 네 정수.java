import java.io.*;
import java.util.Arrays;

public class Main {
    static String[] l;
    static int[] A, B, C, D, AB, CD;
    static long cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        A = new int[n]; B = new int[n]; C = new int[n]; D = new int[n];
        for (int i = 0; i < n; i++) {
            l = br.readLine().split(" ");
            A[i] = Integer.parseInt(l[0]);
            B[i] = Integer.parseInt(l[1]);
            C[i] = Integer.parseInt(l[2]);
            D[i] = Integer.parseInt(l[3]);
        }

        AB = new int[n * n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                AB[i * n + j] = A[i] + B[j];
        Arrays.sort(AB);

        CD = new int[n * n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                CD[i * n + j] = C[i] + D[j];
        Arrays.sort(CD);

        for (int i = 0; i < n * n; i++)
            cnt += upperBound(CD, -AB[i]) - lowerBound(CD, -AB[i]) + 1;

        System.out.println(cnt);
    }

    private static int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length, m = (l + r) / 2;
        while (l < r)  {
            if (arr[m] <= target) l = m + 1;
            else r = m;
            m = (l + r) / 2;
        }
        return m - 1;
    }

    private static int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length, m = (l + r) / 2;
        while (l < r)  {
            if (arr[m] < target) l = m + 1;
            else r = m;
            m = (l + r) / 2;
        }
        return m;
    }

}