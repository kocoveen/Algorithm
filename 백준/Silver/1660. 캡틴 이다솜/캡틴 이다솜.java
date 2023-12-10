import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = 122;
        int[] dp1 = new int[K];
        int[] dp2 = new int[K];
        dp1[1] = 1; dp2[1] = 1;
        for (int i = 2; i < K; i++) {
            dp1[i] = dp1[i-1] + i;
            dp2[i] = dp2[i-1] + dp1[i];
        }
        int[] res = new int[N+1]; // 대포알이 N개 일 때, 가질 수 있는 사면체의 수
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= N; i++) {

            for (int j = 1; j < K; j++) {
                if(dp2[j] <= i) {
                    res[i] = Math.min(res[i], res[i - dp2[j]]+1);
                }
            }

        }
        System.out.println(res[N]);
    }
}