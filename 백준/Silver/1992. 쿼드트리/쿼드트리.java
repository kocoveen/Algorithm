import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] img;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int W;
    static int B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        img = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++)
                img[i][j] = line.charAt(j) - '0';
        }

        quadTree(0, 0, N);

        System.out.println(sb);
    }

    public static void quadTree(int startRow, int startCol, int size) {
        if (isUnited(startRow, startCol, size)) {
            sb.append(img[startRow][startCol]);
            return;
        }

        int newSize = size / 2;
        sb.append("(");
        quadTree(startRow, startCol, newSize);
        quadTree(startRow, startCol + newSize, newSize);
        quadTree(startRow + newSize, startCol, newSize);
        quadTree(startRow + newSize, startCol + newSize, newSize);
        sb.append(")");
    }

    public static boolean isUnited(int startRow, int startCol, int size) {
        int value = img[startRow][startCol];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (value != img[startRow + i][startCol + j])
                    return false;
        return true;
    }

    public static void print() {
        for (int[] ints : img) {
            for (int i : ints)
                System.out.printf("%d", i);
            System.out.println();
        }
    }
}