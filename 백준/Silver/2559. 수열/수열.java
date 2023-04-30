import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] T;
    static int[] Sum;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        T = new int[N + 1];
        Sum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            T[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            if (i < K)
                Sum[i] = Sum[i - 1] + T[i];
            else
                Sum[i] = Sum[i - 1] + T[i] - T[i - K];
        }

        int max = Integer.MIN_VALUE;
        for (int i = K; i <= N; i++)
            if (max < Sum[i])
                max = Sum[i];

        System.out.println(max);
    }
}