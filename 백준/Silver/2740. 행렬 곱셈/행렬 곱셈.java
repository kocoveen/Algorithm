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

        int[][] T = transfer(B, M, K);

        C = new int[N][K];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                int L = innerProduct(A[i], T[j]);
                C[i][j] = L;
            }
        }

        for (int[] l : C) {
            for (int i : l)
                System.out.printf("%d ", i);
            System.out.println();
        }

    }

    private static int[][] transfer(int[][] B, int M, int K) {
        int[][] T = new int[K][M];
        for (int i = 0; i < K; i++)
            for (int j = 0; j < M; j++)
                T[i][j] = B[j][i];
        return T;
    }


    private static int innerProduct(int[] A, int[] B) {
        int answer = 0;
        for (int i = 0; i < A.length; i++)
            answer += A[i] * B[i];
        return answer;
    }
}