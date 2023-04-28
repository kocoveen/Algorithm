import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int[] Num;
    static int[] dp;
    static int N;
    static int maxNum;
    static int SIZE = 501;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        Num = new int[SIZE];
        dp = new int[SIZE];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (maxNum < A || maxNum < B)
                maxNum = Math.max(A, B);
            Num[A] = B;
        }

        dp[0] = 0;

        for (int i = 1; i <= maxNum; i++)
            LIS(i);

        int max = 0;
        for (int i = 1; i <= maxNum; i++)
            max = Math.max(max, dp[i]);

        bw.write(N - max + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static void LIS(int index) {
        if (Num[index] == 0) {
            dp[index] = 0;
            return;
        }
        int max = 0;
        for (int i = 1; i < index; i++)
                if (Num[index] > Num[i] && max < dp[i])
                    max = dp[i];
        dp[index] = max + 1;
    }
}