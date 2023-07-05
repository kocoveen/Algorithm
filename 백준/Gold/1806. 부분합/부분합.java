import java.io.*;
import java.util.Arrays;

public class Main {
    static String[] l;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        int n = Integer.parseInt(l[0]);
        int s = Integer.parseInt(l[1]);
        A = new int[n + 1];

        l = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) A[i] = Integer.parseInt(l[i - 1]) + A[i - 1];

        int en = 1, min = Integer.MAX_VALUE;
        for (int st = 0; st < n; st++) {
            while (en <= n && A[en] - A[st] < s) en++;
            if (en > n) break;
            if (A[en] - A[st] >= s)
                min = Math.min(min, en - st);
        }
        if (min == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);
    }
}