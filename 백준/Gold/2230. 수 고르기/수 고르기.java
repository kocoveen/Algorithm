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

        int en = 0, min = Integer.MAX_VALUE;
        for (int st = 0; st < n; st++) {
            while (en < n && A[en] - A[st] < m) en++;
            if (en == n) break;
            min = Math.min(min, A[en] - A[st]);
        }
        System.out.println(min);
    }
}