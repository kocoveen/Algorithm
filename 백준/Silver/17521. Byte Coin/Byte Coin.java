import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long coin = 0;

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                if (prices[i] <= prices[i + 1]) {
                    // 매도 후 매수
                    w += coin * prices[i];
                    coin = 0;

                    coin = w / prices[i];
                    w %= prices[i];
                } else {
                    // 매도
                    w += coin * prices[i];
                    coin = 0;
                }
            } else {
                // 매도
                w += coin * prices[i];
            }
        }
        System.out.println(w);
    }
}