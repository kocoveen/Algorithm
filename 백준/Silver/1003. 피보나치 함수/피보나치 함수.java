import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Integer[] f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        f = new Integer[41];
        f[0] = 0; f[1] = 1;
        fibonacci(41);
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                sb.append(f[1]).append(" ").append(f[0]).append("\n");
                continue;
            }
            sb.append(f[N - 1]).append(" ").append(f[N]).append("\n");
        }
        bw.write(sb + "");
        bw.close();
    }

    private static void fibonacci(int N) {
        for (int i = 2; i < N; i++)
            f[i] = f[i - 1] + f[i - 2];
    }
}

