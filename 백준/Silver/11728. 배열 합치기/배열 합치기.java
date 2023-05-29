import java.io.*;

public class Main {
    static String[] l;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        int N = Integer.parseInt(l[0]);
        int M = Integer.parseInt(l[1]);

        int[] A = new int[N];
        int[] B = new int[M];
        int[] C = new int[N + M];

        l = br.readLine().split(" ");
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(l[i]);

        l = br.readLine().split(" ");
        for (int i = 0; i < M; i++) B[i] = Integer.parseInt(l[i]);

        int ai = 0, bi = 0, ci = 0;
        while (ai < N || bi < M) {
            if (ai == N) C[ci++] = B[bi++];
            else if (bi == M) C[ci++] = A[ai++];
            else if (A[ai] <= B[bi]) C[ci++] = A[ai++];
            else if (A[ai] > B[bi]) C[ci++] = B[bi++];
        }

        for (int i : C) sb.append(i).append(" ");
        System.out.println(sb);
    }
}