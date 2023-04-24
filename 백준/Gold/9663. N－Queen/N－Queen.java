import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] A; // index = 열, 값 = 행
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new int[N];

        Queen(0, A);
        System.out.println(count);
    }

    public static void Queen(int depth, int[] A) {
        if (depth == N) {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            A[depth] = i;
            if (isPossible(depth, A))
                Queen(depth + 1, A);
        }
    }

    public static boolean isPossible(int col, int[] A) {
        for (int i = 0; i < col; i++) {

            if (A[col] == A[i])
                return false;
            else if (Math.abs(col - i) == Math.abs(A[col] - A[i]))
                return false;
        }
        return true;
    }
}