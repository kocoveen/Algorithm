import java.util.*;

public class Main {

    static int r, a, b;
    static int[] A, B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        while (r-- > 0) {
            A = new int[5];
            B = new int[5];

            a = sc.nextInt();
            for (int i = 0; i < a; i++) A[sc.nextInt()]++;
            b = sc.nextInt();
            for (int i = 0; i < b; i++) B[sc.nextInt()]++;
            System.out.println(findWinner());
        }
    }

    private static char findWinner() {
        for (int i = 4; i > 0; i--) {
            if (A[i] > B[i]) return 'A';
            else if (A[i] < B[i]) return 'B';
        }
        return 'D';
    }
}