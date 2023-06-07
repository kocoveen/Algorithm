import java.io.*;
import java.util.Arrays;

public class Main {
    static double N, sum;

    static int[] scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Double.parseDouble(br.readLine());
        scores = new int[(int) N];
        for (int i = 0; i < N; i++) scores[i] = Integer.parseInt(br.readLine());

        Arrays.sort(scores);

        int v = (int) Math.round(N * 15 / 100);
        int s = ((int) N) - (2 * v);

        for (int i = v; i < N - v; i++) sum += scores[i];

        double ans = Math.round(sum / s);
        System.out.println((int) ans);

    }
}