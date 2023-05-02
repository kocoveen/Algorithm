import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Integer[][] Num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        Num = new Integer[15][15];

        Num[0][0] = 0;
        for (int i = 1; i < Num.length; i++) {
            Num[0][i] = i;
            Num[i][0] = 0;
        }

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            sb.append(population(K, N)).append("\n");
        }

        System.out.print(sb);

    }

    public static int population(int K, int N) {
        if (K == 0 || N == 0)
            return Num[K][N];

        if (Num[K][N] == null)
            Num[K][N] = population(K, N - 1) + population(K - 1, N);
        return Num[K][N];
    }
}