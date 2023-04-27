import java.io.*;

public class Main {
    static int[] Num;
    static Integer[] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        Num = new int[N];
        dp = new Integer[N];

        for (int i = 0; i < N; i++)
            Num[i] = Integer.parseInt(br.readLine());

        bw.write(Math.max(findMax(0), findMax(1))+ "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int findMax(int index) {
        if (index > N - 1)
            return 0;
        else if (index == N - 1)
            return Num[index];

        if (dp[index] == null)
            dp[index] = Math.max(findMax(index + 1),
                    Math.max(Num[index + 1] + findMax(index + 3) + Num[index],
                            findMax(index + 2)  + Num[index]));

        return dp[index];
    }
}