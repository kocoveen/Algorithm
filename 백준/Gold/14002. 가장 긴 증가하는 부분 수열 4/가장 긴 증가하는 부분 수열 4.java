import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String[] l;

    static int N, maxIndex, maxNum;
    static int[] arr;
    static int[] dp;
    static int[] pre;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1];
        pre = new int[N + 1];

        l = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(l[i - 1]);

        Arrays.fill(dp, 1);

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j < i; j++) {
                if(arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
        }

        maxIndex = 1;
        maxNum = dp[1];
        for (int i = 2; i <= N; i++) {
            if (maxNum < dp[i]) {
                maxIndex = i;
                maxNum = dp[i];
            }
        }

        Deque<Integer> ans = new ArrayDeque<>();
        int cur = maxIndex;
        while (cur > 0) {
            ans.addFirst(arr[cur]);
            cur = pre[cur];
        }

        sb.append(ans.size()).append('\n');
        for (Integer i : ans)
            sb.append(i).append(' ');

        System.out.print(sb);
    }
}