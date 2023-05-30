import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String[] l;

    static int T;
    static int N, M;

    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            l = br.readLine().split(" ");
            N = Integer.parseInt(l[0]);
            M = Integer.parseInt(l[1]);

            l = br.readLine().split(" ");
            A = new int[N];
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(l[i]);

            l = br.readLine().split(" ");
            B = new int[M];
            for (int i = 0; i < M; i++) B[i] = Integer.parseInt(l[i]);

            Arrays.sort(A); Arrays.sort(B);
            int a = A.length - 1, b = B.length - 1, cnt = 0;
            while (a >= 0 && b >= 0) {
                if (A[a] > B[b]) {
                    cnt += b + 1;
                    a--;
                } else b--;
            }
            System.out.println(cnt);
        }
    }
}