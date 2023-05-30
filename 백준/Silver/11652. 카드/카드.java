import java.io.*;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N;

    static long[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        num = new long[N];
        for (int i = 0; i < N; i++) num[i] = Long.parseLong(br.readLine());
        Arrays.sort(num);

        int cnt = 0;
        long maxValue = Long.MIN_VALUE;
        int maxCount = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0 || num[i - 1] == num[i]) cnt++;
            else {
                if (cnt > maxCount) {
                    maxCount = cnt;
                    maxValue = num[i - 1];
                }
                cnt = 1;
            }
        }
        if (cnt > maxCount) maxValue = num[N - 1];

        System.out.println(maxValue);
    }
}