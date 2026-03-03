import java.util.Scanner;

public class Main {

    static int N;
    static int[] X;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        
        X = new int[N];
        for (int i = 0; i < N; i++) {
            X[i] = sc.nextInt();
        }

        int max = 0, l = 0, r = N-1;
        while (l < r) {
            max = Math.max(max, (r-l-1) * Math.min(X[r], X[l]) );
        
            if (X[l] < X[r]) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println(max);
    }
}