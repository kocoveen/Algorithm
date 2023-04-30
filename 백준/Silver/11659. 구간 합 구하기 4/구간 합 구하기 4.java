import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] Num;
    static int[] Sum;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Num = new int[N+1];
        Sum = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            Num[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++)
            Sum[i] = Sum[i - 1] + Num[i];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            bw.write(Sum[end] - Sum[start - 1] + "\n");
        }

        bw.flush();
    }
}