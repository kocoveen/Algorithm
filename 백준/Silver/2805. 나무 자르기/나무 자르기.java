import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] Num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Num = new int[N];
        st = new StringTokenizer(br.readLine());

        long max = 0;
        for (int i = 0; i < N; i++) {
            Num[i] = Integer.parseInt(st.nextToken());
            if (max < Num[i])
                max = Num[i];
        }

        long min = 0;
        long mid;

        while (min < max) {
            mid = (min + max) / 2;
            long total = 0;
            for (int i = 0; i < N; i++) {
                long tmp = Num[i] - mid;
                if (tmp < 0)
                    tmp = 0;
                total += tmp;
            }

            if (total < M)
                max = mid;
            else if (total >= M)
                min = mid + 1;
        }
        System.out.println(max - 1);
    }
}