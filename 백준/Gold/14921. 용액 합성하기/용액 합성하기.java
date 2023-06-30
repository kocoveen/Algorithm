import java.io.*;
import java.util.Arrays;

import static java.lang.Math.*;

public class Main {
    static String[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        l = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            A[i] = Integer.parseInt(l[i]);

        int a1 = 100000001;
        int a2 = 100000001;
        int l = 0, r = n - 1;
        while (l < r) {
            if (Math.abs(a1 + a2) > Math.abs(A[l] + A[r])) {
                a1 = A[l];
                a2 = A[r];
            }

            if (Math.abs(A[l] + A[r - 1]) > Math.abs(A[l + 1] + A[r])) l = l + 1;
            else r = r - 1;

        }
        System.out.println(a1 + a2);
    }

}