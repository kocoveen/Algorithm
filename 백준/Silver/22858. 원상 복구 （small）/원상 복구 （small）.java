import java.util.Scanner;

public class Main {

    static int N, K;
    static int[] D, P, S;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        S = new int[N];
        for (int i = 0; i < N; i++) {
            S[i] = sc.nextInt();
        }

        D = new int[N];
        for (int i = 0; i < N; i++) {
            int d = sc.nextInt()-1;
            D[d] = i;
        }

        P = new int[N];
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                P[j] = S[D[j]];
            }
            
            System.arraycopy(P, 0, S, 0, N);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(P[i] + " ");
        }
    }
}