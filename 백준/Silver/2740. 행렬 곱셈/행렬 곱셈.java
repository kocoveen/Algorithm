import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] A;
    static int[][] B;
    static int[][] C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        B = new int[M][K];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++)
                B[i][j] = Integer.parseInt(st.nextToken());
        }

        C = new int[N][K];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < K; j++)
                for(int k = 0; k < M; k++)
                    C[i][j] += A[i][k] * B[k][j];


        for (int[] l : C) {
            for (int i : l)
                sb.append(i).append(" ");
            sb.append("\n");
        }
        
        bw.write(sb + "");
        bw.flush();
    }
}