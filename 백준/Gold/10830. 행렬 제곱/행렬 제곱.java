import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] O;
    static int[][] K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        O = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                O[i][j] = Integer.parseInt(st.nextToken()) % 1000;
        }

        K = power(O, B, N);

        for (int[] l : K) {
            for (int i : l)
                System.out.printf("%d ", i);
            System.out.println();
        }

        bw.write(sb + "");
        bw.flush();
    }

    private static int[][] power(int[][] A, long B, int N) {
        if (B == 1L)
            return A;

        int[][] tmp = power(A, B / 2, N);
        tmp = multiply(tmp, tmp, N);

        if (B % 2 == 1L)
            tmp = multiply(tmp, O, N);

        return tmp;
    }

    private static int[][] multiply(int[][] A1, int[][] A2, int N) {
        int[][] tmp = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                for (int k = 0; k < N; k++) {
                    tmp[i][j] += (A1[i][k] * A2[k][j]);
                    tmp[i][j] %= 1000;
                }
        return tmp;
    }

}