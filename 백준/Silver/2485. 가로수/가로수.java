import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int[] dot = new int[N];
        int[] d = new int[N-1];

        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            dot[i] = x;
            if (min > dot[i])
                min = dot[i];
            if (max < dot[i])
                max = dot[i];
        }

        for (int i = 0; i < N - 1; i++)
            d[i] = Math.abs(dot[i] - dot[i+1]);

        int minD = d[0];
        for (int i = 0; i < N - 2; i++) {
            int g = gcb(d[i], d[i+1]);
            if (minD > g)
                minD = g;
        }

        int cnt = ((max - min) / minD) + 1 - dot.length;
        bw.write(cnt + "");

        bw.flush();
        br.close();
        bw.close();
    }

    private static int gcb(int a, int b) {
        int A = Math.max(a, b);
        int B = Math.min(a, b);
        while (B != 0) {
            int r = A % B;
            A = B;
            B = r;
        }
        return A;
    }
}