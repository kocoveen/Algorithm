import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] Num;
    static int[] Sum;
    static int N;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        Num = new int[3][N];
        Sum = new int[3];

        Arrays.fill(Sum, -1001);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Num[0][i] = Integer.parseInt(st.nextToken());
            Num[1][i] = Integer.parseInt(st.nextToken());
            Num[2][i] = Integer.parseInt(st.nextToken());
        }

        Sum[0] = Num[0][0];
        Sum[1] = Num[0][1];
        Sum[2] = Num[0][2];
        bw.write(findMax(N) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int findMax(int N) {
        for (int i = 0; i < N - 1; i++) {
            Num[0][i+1] += Math.min(Num[1][i], Num[2][i]);
            Num[1][i+1] += Math.min(Num[2][i], Num[0][i]);
            Num[2][i+1] += Math.min(Num[0][i], Num[1][i]);
        }
        return Math.min(Num[0][N-1], Math.min(Num[1][N-1], Num[2][N-1]));
    }
}