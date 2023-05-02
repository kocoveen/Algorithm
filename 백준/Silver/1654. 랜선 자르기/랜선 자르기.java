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
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        Num = new int[K];

        long max = 0;
        for (int i = 0; i < K; i++) {
            Num[i] = Integer.parseInt(br.readLine());
            if (max < Num[i])
                max = Num[i];
        }
        max++;

        long min = 0;
        long mid;

        while (min < max) {
            mid = (min + max) / 2;
            long count = 0;

            for (int i = 0; i < K; i++)
                count += (Num[i] / mid);

            if (count >= N)
                min = mid + 1;
            else
                max = mid;
        }

        System.out.println(min - 1);
    }
}