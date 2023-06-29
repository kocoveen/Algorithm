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
            sb.append(binarySearch(A, B[i])).append('\n');

        System.out.println(sb);
    }

    private static int binarySearch(int[] A, int target) {
        int l = 0, r = A.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] == target) return 1;
            else if (A[m] < target) l = m + 1;
            else r = m;
        }
        return 0;
    }
}