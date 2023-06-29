import java.io.*;
import java.util.Arrays;

public class Main {
    static String[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        l = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(l[i]);

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        l = br.readLine().split(" ");
        for (int i = 0; i < M; i++)
            B[i] = Integer.parseInt(l[i]);

        Arrays.sort(A);

        for (int i = 0; i < l.length; i++)
            sb.append(upperBound(A, B[i]) - lowerBound(A, B[i]) + 1).append(' ');

        System.out.println(sb);
    }

    private static int lowerBound(int[] A, int target) {
        int l = 0, r = A.length, m = (l + r) / 2;
        while (l < r) {
            if (A[m] < target) l = m + 1;
            else if (target <= A[m]) r = m;
            m = (l + r) / 2;
        }
        return m;
    }

    private static int upperBound(int[] A, int target) {
        int l = 0, r = A.length, m = (l + r) / 2;
        while (l < r) {
            if (A[m] <= target) l = m + 1;
            else if (target < A[m]) r = m;
            m = (l + r) / 2;
        }
        return m - 1;
    }


}