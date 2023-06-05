import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String[] l;

    static int T, N;
    static long sum, max;

    static int[] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            N = Integer.parseInt(br.readLine());
            S = new int[N];
            l = br.readLine().split(" ");
            for (int i = 0; i < N; i++) S[i] = Integer.parseInt(l[i]);

            max = S[N - 1];
            sum = 0;

            for (int i = N - 1; i >= 0; i--) {
                if (max < S[i]) max = S[i];
                sum += max - S[i];
            }

            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
}