import java.io.*;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] P;
    static int[] D;
    static int[] DSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        D = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++)
            D[i] = Integer.parseInt(st.nextToken());

        DSum = new int[N];
        for (int i = N - 2; i >= 0; i--)
            DSum[i] = DSum[i + 1] + D[i];

        P = new int[N][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i][0] = i;
            P[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(P, (o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int total = 0;
        int l = N - 1;
        for (int[] p : P) {
            if (p[0] == N - 1 || p[0] >= l)
                continue;
            total += p[1] * (DSum[p[0]] - DSum[l]);
            l = p[0];
        }

        System.out.println(total);
    }
}