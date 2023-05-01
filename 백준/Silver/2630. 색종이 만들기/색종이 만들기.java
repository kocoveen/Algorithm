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
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                img[i][j] = Integer.parseInt(st.nextToken());
        }
        quad(0, 0, N);

        System.out.println(W);
        System.out.println(B);
    }

    public static void quad(int startRow, int startCol, int size) {
        if (isOneColor(startRow, startCol, size)) {
            if (img[startRow][startCol] == 0)
                W++;
            else
                B++;
            return;
        }

        int newSize = size / 2;
        quad(startRow, startCol, newSize);
        quad(startRow, startCol + newSize, newSize);
        quad(startRow + newSize, startCol, newSize);
        quad(startRow + newSize, startCol + newSize, newSize);
    }

    public static boolean isOneColor(int startRow, int startCol, int size) {
        int value = img[startRow][startCol];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (value != img[startRow + i][startCol + j])
                    return false;
        return true;
    }
}