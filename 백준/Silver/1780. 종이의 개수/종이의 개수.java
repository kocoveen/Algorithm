import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] img;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int Mone;
    static int zero;
    static int Pone;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        img = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                img[i][j] = Integer.parseInt(st.nextToken());
        }

        nonuTree(0, 0, N);

        System.out.println(Mone);
        System.out.println(zero);
        System.out.println(Pone);

    }

    public static void nonuTree(int startRow, int startCol, int size) {
        if (isUnited(startRow, startCol, size)) {
            switch (img[startRow][startCol]) {
                case -1: Mone++; break;
                case 0: zero++; break;
                case 1: Pone++; break;
            }
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                nonuTree(startRow + i * newSize, startCol + j * newSize, newSize);
    }

    public static boolean isUnited(int startRow, int startCol, int size) {
        int value = img[startRow][startCol];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (img[startRow + i][startCol + j] != value)
                    return false;
        return true;
    }
}