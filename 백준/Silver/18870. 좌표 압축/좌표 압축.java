import java.io.*;
import java.util.*;

public class Main {
    static String[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N], B = new int[N], C = new int[N];
        l = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            A[i] = C[i] = Integer.parseInt(l[i]);
        }

        Arrays.sort(A);

        int j = 0;
        for (int i = 0; i < N; i++) {
            if (i != 0 && A[i - 1] == A[i]) continue;
            B[j++] = A[i];
        }

        for (int i : C)
            sb.append(binarySearch(B, i, j)).append(' ');

        System.out.println(sb);
    }

    private static int binarySearch(int[] B, int target, int length) {
        int l = 0, r = length, m = (l + r) / 2;
        while (l < r) {
            if (B[m] == target) return m;
            else if (B[m] < target) l = m + 1;
            else if (target < B[m]) r = m;
            m = (l + r) / 2;
        }
        return -1;
    }
}