import java.util.Scanner;

public class Main {

    static int N;
    static boolean[][] box;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int size = 1 + 4 * (N - 1);
        box = new boolean[size][size];

        makeSquare(N, 0, 0);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(box[i][j] ? '*' : ' ');
            }
            System.out.println();
        }
    }

    private static void makeSquare(int N, int r, int c) {
        if (N == 0) {
            return;
        }

        int A = 1 + 4 * (N - 1);

        for (int i = 0; i < A; i++) {
            box[r][c + i] = true;
            box[r + A-1][c + i] = true;
        }

        for (int i = 0; i < A; i++) {
            box[r + i][c] = true;
            box[r + i][c + A-1] = true;
        }

        makeSquare(N - 1, r + 2, c + 2);
    }
}