import java.io.*;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] A = new char[N][N];
        for (char[] rows : A)
            Arrays.fill(rows, '*');
        fractal(A, 0, 0, N);
        print(A);
    }

    private static void fractal(char[][] A, int r, int c, int size) {
        if (size < 3) return;

        int startRow = r + size / 3;
        int startCol = c + size / 3;

        int localSize = size / 3;

        for (int i = startRow; i < startRow + localSize; i++)
            for (int j = startCol; j < startCol + localSize; j++)
                A[i][j] = ' ';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                fractal(A, r + localSize * i, c + localSize * j, localSize);
            }
        }
    }

    private static void print(char[][] fractal) {
        StringBuilder sb = new StringBuilder();
        for (char[] rows : fractal) {
            for (char e : rows)
                sb.append(e);
            sb.append('\n');
        }
        System.out.print(sb);
    }
}