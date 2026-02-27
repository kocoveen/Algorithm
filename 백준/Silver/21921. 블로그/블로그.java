import java.util.Scanner;

public class Main {
    static int N, X;
    static int[] A, S;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        X = sc.nextInt();

        A = new int[N+1];
        S = new int[N+1];

        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
            S[i] = S[i-1] + A[i];
        }

        int i = 0, j = i + X;
        int max = 0;
        int count = 0;
        while (i < j && j <= N) {
            int visit = S[j++] - S[i++];
            if (max < visit) {
                max = visit;
                count = 1;
            } else if (max == visit) {
                count++;
            }
        }
        
        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}