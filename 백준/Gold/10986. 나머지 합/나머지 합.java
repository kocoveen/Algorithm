import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static long[] Num;
    static long[] Sum;
    static long[] Reminder;
    static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        Num = new long[N + 1];
        Sum = new long[N + 1];
        Reminder = new long[(int) M];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            Num[i] = Long.parseLong(st.nextToken());

        for (int i = 1; i <= N; i++)
            Sum[i] = Sum[i - 1] + Num[i];

        for (int j = 1; j <= N; j++)
            Reminder[(int) (Sum[j] % M)]++;

        count = Reminder[0];
        for (int i = 0; i < M; i++)
            count += (Reminder[i] * (Reminder[i] - 1)) / 2;

        System.out.println(count);
    }
}