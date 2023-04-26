import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int[][] Num;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        Num = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++)
                Num[i][j] = Integer.parseInt(st.nextToken());
        }

        bw.write(findMax(N) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int findMax(int N) {
        for (int i = N-1; i >= 1; i--)
            for (int j = 0; j < N - 1; j++)
                Num[i-1][j] += Math.max(Num[i][j], Num[i][j+1]);
        return Num[0][0];
    }
}