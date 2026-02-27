import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] A, B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = sc.nextInt();
        M = sc.nextInt();

        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        B = new int[M];
        for (int j = 0; j < M; j++) {
            B[j] = sc.nextInt();
        }

        int i = 0, j = 0, k = 0;
        while (i < N && j < M) {
            if (A[i] < B[j]) {
                sb.append(A[i++]);
            } else {
                sb.append(B[j++]);
            }
            sb.append(" ");
        }

        while (i < N) {
            sb.append(A[i++]).append(" ");
        }

        while (j < M) {
            sb.append(B[j++]).append(" ");
        }

        System.out.print(sb.toString());
    }
}