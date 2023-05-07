import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] A;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] A = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < A.length; i++) {
            int k = A[i]; int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if (k < A[j])
                    A[j + 1] = A[j];
                else break;
            }
            A[j + 1] = k;
        }

        for (int i : A)
            System.out.printf("%d ", i);
    }
}