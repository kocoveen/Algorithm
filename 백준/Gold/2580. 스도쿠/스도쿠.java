import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = new int[81];
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                A[i * 9 + j] = Integer.parseInt(st.nextToken());
            }
        }

        Sudoku(0);

    }

    public static void Sudoku(int startPoint) {
        for (int i = startPoint; i < 81; i++) {
            if (A[i] == 0) {
                for (int k = 1; k <= 9; k++) {
                    A[i] = k;
                        if (isPossible(i, k)) {
                        Sudoku(i + 1);
                    }
                }
                A[i] = 0;
                return;
            }
        }
        print();
        System.exit(0);
    }

    public static boolean isPossible(int index, int value) {
        int row = index / 9;
        int col = index % 9;
        for (int i = 0; i < 9; i++) {
            if (i != col && A[row * 9 + i] == value)
                return false;
            if (i != row && A[i * 9 + col] == value)
                return false;
        }

        int x = row / 3 * 3; //3x3 박스의 row 부분의 시작점
        int y = col / 3 * 3; //3x3 박스의 col 부분의 시작점
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (!((x+i) == row && (y+j) == col) && A[(x+i) * 9 + (y+j)] == value)
                    return false;
        return true;
    }

    public static void print() {
        for (int i = 0; i < 81; i++) {
            if (i != 80) {
                sb.append(A[i]).append(" ");
                if((i + 1) % 9 == 0)
                    sb.append("\n");
            }
            else
                sb.append(A[i]);
        }
        System.out.print(sb);
    }
}