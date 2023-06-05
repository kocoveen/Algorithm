import java.io.*;
import java.util.Arrays;

public class Main {
    static String[] l;

    static int N, max = 0;

    static int[] R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        R = new int[N];

        for (int i = 0; i < N; i++) R[i] = Integer.parseInt(br.readLine());

        Arrays.sort(R);

        for (int i = 0; i < N; i++) {
            max = Math.max(R[i] * (N - i), max);
        }

        System.out.println(max);
    }
}