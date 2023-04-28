import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int[] Num;
    static Integer[] dpAsc;
    static Integer[] dpDesc;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        Num = new int[N+2];
        dpAsc = new Integer[N+2];
        dpDesc = new Integer[N+2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            Num[i] = Integer.parseInt(st.nextToken());

        dpAsc[0] = 0;
        dpDesc[N+1] = 0;

        for (int i = 1; i <= N; i++) {
            LIS(i, dpAsc, 0);
            LIS(N + 1 - i, dpDesc, 1);
        }

        int max = 0;
        for (int i = 1; i <= N; i++)
            max = Math.max(max, dpAsc[i] + dpDesc[i]);

        bw.write(max - 1 + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static void LIS(int index, Integer[] dp, int order) {
        if (order == 0) {
            int max = 0;
            for (int i = 0; i < index; i++)
                if (Num[index] > Num[i] && max < dp[i])
                    max = dp[i];
            dp[index] = max + 1;
        }

        if (order == 1) {
            int max = 0;
            for (int i = N + 1; i > index; i--)
                if (Num[index] > Num[i] && max < dp[i])
                    max = dp[i];
            dp[index] = max + 1;
        }
    }
}