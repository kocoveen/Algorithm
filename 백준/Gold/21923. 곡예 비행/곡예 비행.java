import java.util.Scanner;

public class Main {
    static int N, M;
    static long[][] scores;
    static Long[][] ascending;
    static Long[][] descending;
    static long INF = 20_000_000_000_000L;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        scores = new long[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                scores[i][j] = sc.nextInt();
            }
        }

        ascending = new Long[N][M];
        descending = new Long[N][M];

        long max = -INF;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(max, ascending(i, j) + descending(i, j));
            }
        }
        System.out.println(max);
    }

    private static long ascending(int i, int j) {
        if (i == N-1 && j == 0) return scores[i][j]; // 시작점이면
        if (i >= N || j < 0) return -INF;
        if (ascending[i][j] != null) return ascending[i][j];

        return ascending[i][j] = scores[i][j] + Math.max(
            ascending(i+1, j), 
            ascending(i, j-1)
        ); 
    }

    private static long descending(int i, int j) {
        if (i == N-1 && j == M-1) return scores[i][j]; // 도착점이면
        if (i >= N || j >= M) return -INF;
        if (descending[i][j] != null) return descending[i][j];

        return descending[i][j] = scores[i][j] + Math.max(
            descending(i+1, j), 
            descending(i, j+1)
        );
    }

}