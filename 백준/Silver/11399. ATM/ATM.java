import java.io.*;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] P;
    static int[] Sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        P = new int[N];
        Sum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            P[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(P);

        for (int i = 1; i <= N; i++)
            Sum[i] = Sum[i - 1] + P[i - 1];

        int sum = 0;
        for (int i = 0; i <= N; i++)
            sum += Sum[i];

        System.out.println(sum);
    }
}