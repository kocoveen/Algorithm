import java.io.*;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, K;
    static int[] V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        V = new int[N];
        for (int i = 0; i < N; i++)
            V[i] = Integer.parseInt(br.readLine());

        int i = N - 1;
        int C = 0;
        while (K != 0) {
            if (V[i] > K) {
                i--;
                continue;
            }
            K -= V[i];
            C++;
        }
        System.out.println(C);
    }
}