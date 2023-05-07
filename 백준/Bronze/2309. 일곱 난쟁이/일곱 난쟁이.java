import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] A;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        A = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int K = Integer.parseInt(br.readLine());
            A[i] = K;
            sum += A[i];
        }

        int diff = sum - 100;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (diff == A[i] + A[j]) {
                    A[i] = 100;
                    A[j] = 100;
                    break;
                }
            }
            if (A[i] == 100)
                break;
        }
        Arrays.sort(A);
        for (int i = 0; i < 7; i++) {
            System.out.println(A[i]);
        }
    }
}